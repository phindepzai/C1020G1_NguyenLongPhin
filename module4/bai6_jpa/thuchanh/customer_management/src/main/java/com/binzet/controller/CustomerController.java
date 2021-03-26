package com.binzet.controller;

import com.binzet.entity.Customer;
import com.binzet.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("list",customerService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "save";
    }

    @PostMapping("/save")
    public String save(Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "save";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        customerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable long id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "view";
    }
}
