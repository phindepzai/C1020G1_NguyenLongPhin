package com.binzet.customer.controller;

import com.binzet.customer.entity.Customer;
import com.binzet.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String home(Model model,@RequestParam(required = false) String language){
        model.addAttribute("list",customerService.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id,@RequestParam(required = false) String language){
        model.addAttribute("customer",customerService.findById(id));
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model,@RequestParam(required = false) String language){
        model.addAttribute("customer",customerService.findById(id));
        return "save";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        customerService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }
}
