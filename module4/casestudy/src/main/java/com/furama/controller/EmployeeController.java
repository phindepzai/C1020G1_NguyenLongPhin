package com.furama.controller;

import com.furama.entity.employee.Employee;
import com.furama.service.employees.EmployeePropertyService;
import com.furama.service.employees.EmployeeService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeePropertyService employeePropertyService;

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("list",employeeService.findAll(pageable));
        return "employees/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("positionList",employeePropertyService.findAllPosition());
        model.addAttribute("educationDegreeList",employeePropertyService.findAllEducationDegree());
        model.addAttribute("divisionList",employeePropertyService.findAllDivision());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        check.setCreate(true);
        return "employees/save";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            return "login/404";
        }
        model.addAttribute("employee", employee);
        model.addAttribute("positionList",employeePropertyService.findAllPosition());
        model.addAttribute("educationDegreeList",employeePropertyService.findAllEducationDegree());
        model.addAttribute("divisionList",employeePropertyService.findAllDivision());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        check.setCreate(false);
        check.setEmployee(employee);
        return "employees/save";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id){
        if (employeeService.findById(id) == null){
            return "login/404";
        }
        model.addAttribute("employee",employeeService.findById(id));
        return "employees/view";
    }

    @PostMapping("/save")
    public String save(Model model, @Validated Employee employee, BindingResult bindingResult, @RequestParam(required = false) String password){
        if (bindingResult.hasErrors()){
            model.addAttribute("employee",employee);
            model.addAttribute("positionList",employeePropertyService.findAllPosition());
            model.addAttribute("educationDegreeList",employeePropertyService.findAllEducationDegree());
            model.addAttribute("divisionList",employeePropertyService.findAllDivision());
            model.addAttribute("password",password);
            return "employees/save";
        }
        employeePropertyService.setUser(employee, password);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        if (employeeService.findById(id) == null){
            return "login/404";
        }
        employeeService.delete(id);
        return "redirect:/employees/list";
    }
}
