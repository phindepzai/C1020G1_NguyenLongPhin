package com.binzet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private Map<String, String> map = new HashMap<>();

    @GetMapping("/")
    public String goHome() {
        map.put("hello","ni hao");
        map.put("thanks","xi xia");
        return "/home";
    }

    @PostMapping("/")
    public String translate(@RequestParam String en, Model model) {
        model.addAttribute("en",en);
        if (map.get(en) != null){
            model.addAttribute("china",map.get(en));
        } else {
            model.addAttribute("error","not found");
        }
        return "/home";
    }
}
