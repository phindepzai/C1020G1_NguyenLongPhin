package com.binzet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String goHome(Model model){
        return "/home";
    }

    @PostMapping("/")
    public String convert(@RequestParam int usd, Model model){
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",usd*23000);
        return "/home";
    }
}
