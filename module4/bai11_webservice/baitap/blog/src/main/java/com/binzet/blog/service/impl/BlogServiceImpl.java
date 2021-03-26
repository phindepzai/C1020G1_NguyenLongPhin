package com.binzet.blog.service.impl;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.repository.BlogRepository;
import com.binzet.blog.service.BlogService;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByCategory(int id) {
        return blogRepository.findALLByCategory(categoryService.findById(id));
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
}
