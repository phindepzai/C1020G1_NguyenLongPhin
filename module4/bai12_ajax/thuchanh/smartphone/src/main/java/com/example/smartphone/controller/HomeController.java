package com.example.smartphone.controller;

import com.example.smartphone.entity.Smartphone;
import com.example.smartphone.serivce.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping("/")
    public String showIndex() {
        return "phones/index";
    }
}