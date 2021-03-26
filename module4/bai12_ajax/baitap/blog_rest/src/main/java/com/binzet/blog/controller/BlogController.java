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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/page")
    public ResponseEntity<Page<Blog>> getList(@RequestParam(required = false) String key, @RequestParam(required = false) String idCate, @PageableDefault(size = 5) Pageable pageable) {
        PageKey pageKey = new PageKey();
        pageable = pageable.previousOrFirst();
        if (key == null & idCate == null){
            key = "";
            idCate = "";
        }
        if (key.equals("") && idCate.equals("")) {
            if (pageable.getPageNumber() > blogService.findAll(pageable).getTotalPages()) {
                return new ResponseEntity<Page<Blog>>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Page<Blog>>(blogService.findAll(pageable), HttpStatus.OK);
        } else if (key.equals("")) {
            if (pageable.getPageNumber() > blogService.findAllByCategory(pageable, Integer.parseInt(idCate)).getTotalPages()) {
                return new ResponseEntity<Page<Blog>>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Page<Blog>>(blogService.findAllByCategory(pageable, Integer.parseInt(idCate)),
                    HttpStatus.OK);
        } else {
            if (pageable.getPageNumber() > blogService.findAllByTitle(pageable, key).getTotalPages()) {
                return new ResponseEntity<Page<Blog>>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Page<Blog>>(blogService.findAllByTitle(pageable, key), HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@RequestParam String key, @PageableDefault(size = 5) Pageable pageable) {
        pageable = pageable.first();
        return new ResponseEntity<Page<Blog>>(blogService.findAllByTitle(pageable, key), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    private ResponseEntity<Void> delete(@PathVariable int id){
        blogService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
