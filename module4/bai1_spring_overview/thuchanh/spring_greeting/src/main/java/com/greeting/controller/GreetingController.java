package com.greeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("name","Binz");
        return "/home";
    }
}
