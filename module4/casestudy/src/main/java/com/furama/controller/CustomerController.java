package com.furama.controller;

import com.furama.entity.customer.Customer;
import com.furama.service.customers.CustomerService;
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
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("list", customerService.findAll(pageable));
        return "customers/list";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable String id) {
        if (customerService.findById(id) == null) {
            return "login/404";
        }
        model.addAttribute("customer", customerService.findById(id));
        return "customers/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        if (customerService.findById(id) == null) {
            return "login/404";
        }
        customerService.delete(id);
        return "redirect:/customers/list";
    }

    @PostMapping("/save")
    public String save(Model model, @Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
//            model.addAttribute("error",bindingResult.getAllErrors());
            model.addAttribute("customerTypeList", customerService.findAllCustomerType());
            return "customers/save";
        }
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "login/404";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        check.setCreate(false);
        check.setCustomer(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", customerService.findAllCustomerType());
        return "customers/save";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerService.findAllCustomerType());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        check.setCreate(true);
        return "customers/save";
    }
}
