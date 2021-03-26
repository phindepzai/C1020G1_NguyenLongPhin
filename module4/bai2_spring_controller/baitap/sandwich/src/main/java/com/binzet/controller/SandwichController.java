package com.binzet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("")
    public String goHome(){
        return "/index";
    }

    @PostMapping
    public String getCondiments(@RequestParam String[] condiments, Model model){
        model.addAttribute("condiments", condiments);
        return "/rel";
    }
}
