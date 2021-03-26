package com.binzet.blog.service;

import com.binzet.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void save(Blog blog);
    void delete(int id);
    List<Blog> findAll(int page);
    List<Blog> findAllByCategory(int page, int id);
    List<Blog> findAllByTitle(int page ,String title);
    Blog findById(int id);
    List<Blog> findBlogByOrderByDate(String title, int page, int type);
}
