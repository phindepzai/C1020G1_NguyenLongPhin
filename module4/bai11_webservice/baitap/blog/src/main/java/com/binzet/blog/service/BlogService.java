package com.binzet.blog.service;

import com.binzet.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    List<Blog> findAllByCategory(int id);
    Blog findById(int id);
}
