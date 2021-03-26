package com.binzet.blog.controller;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.entity.Category;
import com.binzet.blog.service.BlogService;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> categorys(){
        List<Category> categorys = categoryService.findAll();
        if (categorys.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(categorys, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> blogs(){
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @GetMapping("/categorys/{id}")
    public ResponseEntity<List<Blog>> category(@PathVariable int id){
        List<Blog> blogs = blogService.findAllByCategory(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id){
        Blog blog = blogService.findById(id);
        System.out.println("Fetching Blog with id " + id);
        if (blog == null){
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    }
}
