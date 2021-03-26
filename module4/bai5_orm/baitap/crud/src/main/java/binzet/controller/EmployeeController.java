package binzet.controller;

import binzet.entity.Employee;
import binzet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "/home";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String goEdit(Model model, @PathVariable int id) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/update";
    }

    @GetMapping("/view/{id}")
    public String goView(Model model, @PathVariable int id) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "redirect:/";
    }

    @PostMapping({"/update","/create"})
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }
}
