package binzet.controller;

import binzet.model.Product;
import binzet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("list",productService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String goUpdate(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "/update";
    }

    @GetMapping("/view/{id}")
    public String goView(@PathVariable int id, Model model){
        model.addAttribute("product",productService.getById(id));
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(Product product){
        productService.save(product);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/";
    }
}
