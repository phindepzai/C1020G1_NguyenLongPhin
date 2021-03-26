package com.binzet.cart_management.controller;

import com.binzet.cart_management.model.Cart;
import com.binzet.cart_management.model.Product;
import com.binzet.cart_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", productService.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id,@ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        Integer i = cart.getMap().get(product);
        if (i != null){
            model.addAttribute("amount", i);
        } else {
            model.addAttribute("amount",0);
        }
        return "view";
    }

    @GetMapping("/add/{id}")
    public String add(Model model, @PathVariable int id, @ModelAttribute("cart") Cart cart, @RequestParam int number) {
        Product product = productService.findById(id);
        cart.add(product,number);
        model.addAttribute("product", product);
        model.addAttribute("message", cart.getMap().get(product));
        return "redirect:/view/"+id;
    }

    @GetMapping("/sub/{id}")
    public String sub(Model model, @PathVariable int id, @ModelAttribute("cart") Cart cart,@RequestParam int number) {
        Product product = productService.findById(id);
        cart.subtract(product,number);
        model.addAttribute("product", product);
        model.addAttribute("message", cart.getMap().get(product));
        return "redirect:/view/"+id;
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        cart.delete(product);
        model.addAttribute("product", product);
        model.addAttribute("message", 0);
        return "redirect:/view/"+id;
    }

    @GetMapping("/cart")
    public String cart(Model model, @ModelAttribute("cart") Cart cart){
        model.addAttribute("list",cart.getMap().keySet());
        model.addAttribute("map",cart.getMap());
        return "cart";
    }
}
