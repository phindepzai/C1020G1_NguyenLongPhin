package com.binzet.controller;

import com.binzet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model, Pageable pageable){
        model.addAttribute("list",bookService.findAll(pageable));
        return "index";
    }

    @GetMapping("/booking/{id}")
    public String booking(@PathVariable int id,Model model){
        model.addAttribute("code",bookService.rentBook(id));
        return "booking";
    }

    @GetMapping("/give/{id}")
    public String giveBack(@PathVariable int id,Model model){
        model.addAttribute("book",id);
        return "give";
    }

    @PostMapping("/give")
    public String give(@RequestParam String code,@RequestParam int id,Model model){
        model.addAttribute("give",bookService.giveBookBack(code,id));
        return "booking";
    }

    @PostMapping("/booking")
    public String booked(Model model){
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String error(){
        return "redirect:/";
    }
}
