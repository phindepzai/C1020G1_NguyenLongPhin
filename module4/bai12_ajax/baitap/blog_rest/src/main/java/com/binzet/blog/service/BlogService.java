package com.binzet.blog.service;

import com.binzet.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void save(Blog blog);
    void delete(int id);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory(Pageable pageable,int id);
    Page<Blog> findAllByTitle(Pageable pageable,String title);
    Blog findById(int id);
    Page<Blog> findBlogByOrderByDate(String title,Pageable pageable,int type);
}
