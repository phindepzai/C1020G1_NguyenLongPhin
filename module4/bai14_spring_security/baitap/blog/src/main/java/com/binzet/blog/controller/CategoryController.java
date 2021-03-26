package com.binzet.blog.controller;

import com.binzet.blog.entity.Category;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String homeCategory(Model model){
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        return "/categorys/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute( "category",new Category() );
        return "/categorys/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute( "category", categoryService.findCategoryById( id ) );
        return "/categorys/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        categoryService.deleteCategory( id );
        return "redirect:/categorys";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Category category){
        categoryService.saveCategory( category );
        return "redirect:/categorys";
    }
}