package com.binzet.form_regis.controller;

import com.binzet.form_regis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("user",user);
            return "index";
        }else {

            return "success";
        }
    }
}
