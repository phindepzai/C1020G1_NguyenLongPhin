package com.binzet.blog.controller;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.entity.PageKey;
import com.binzet.blog.service.BlogService;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        PageKey pageKey = new PageKey();
        pageKey.setPage(1);
        model.addAttribute("list", blogService.findAll(1));
        model.addAttribute("pageKey", pageKey);
        model.addAttribute("categorys", categoryService.findAll());
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,@RequestParam String key){
        PageKey pageKey = new PageKey();
        pageKey.setPage(1);
        pageKey.setKey(key);
        model.addAttribute("list", blogService.findAllByTitle(1,key));
        model.addAttribute("pageKey", pageKey);
        model.addAttribute("categorys", categoryService.findAll());
        return "index";
    }

    @GetMapping("/page")
    public String getList(Model model, @RequestParam int page, @RequestParam String key, @RequestParam String idCate) {
        PageKey pageKey = new PageKey();
        if (key == null && idCate == null) {
            model.addAttribute("list", blogService.findAll(page));
        } else if (key == null) {
            model.addAttribute("list", blogService.findAllByCategory(page, Integer.parseInt(idCate)));
            pageKey.setIdCate(Integer.parseInt(idCate));
        } else {
            model.addAttribute("list", blogService.findAllByTitle(page, key));
            pageKey.setKey(key);
        }
        pageKey.setPage(page);
        model.addAttribute("pageKey", pageKey);
        model.addAttribute("categorys", categoryService.findAll());
        return "layout";
    }
}
