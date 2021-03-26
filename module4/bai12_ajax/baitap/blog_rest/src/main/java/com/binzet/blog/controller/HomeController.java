package com.binzet.blog.controller;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.entity.PageKey;
import com.binzet.blog.service.BlogService;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model,@PageableDefault(size = 5) Pageable pageable) {
        PageKey pageKey = new PageKey();
        pageKey.setPage(1);
        model.addAttribute("list", blogService.findAll(pageable));
        model.addAttribute("pageKey", pageKey);
        model.addAttribute("categorys", categoryService.findAll());
        return "index";
    }
}
