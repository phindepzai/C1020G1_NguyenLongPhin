package com.binzet.blog.controller;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.service.BlogService;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String home(@PageableDefault(size = 5) Pageable pageable, Model model,String pageStr) {
        model.addAttribute("list", blogService.findAll(pageable));
        model.addAttribute("categorys", categoryService.findAll());
        if (pageStr == null){
            pageStr = "index";
        }
        return pageStr;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", categoryService.findAll());
        return "save";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Blog blog = blogService.findById(id);
        blog.setCategory(null);
        model.addAttribute("blog", blog);
        model.addAttribute("categorys", categoryService.findAll());
        return "save";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "post";
    }

    @GetMapping("/category/{id}")
    public String category(@PageableDefault(size = 5) Pageable pageable,@PathVariable int id,Model model){
        model.addAttribute("list",blogService.findAllByCategory(pageable,id));
        model.addAttribute("categorys", categoryService.findAll());
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        return "contact";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String title,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("list",blogService.findAllByTitle(pageable,title));
        model.addAttribute("title",title);
        model.addAttribute("categorys", categoryService.findAll());
        return "index";
    }

    @GetMapping("/sort")
    public String sort(Model model,@RequestParam int type,Pageable pageable,@RequestParam String title){
        model.addAttribute("list",blogService.findBlogByOrderByDate(title,pageable,type));
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("title",title);
        model.addAttribute("type",type);
        return "index";
    }
}
