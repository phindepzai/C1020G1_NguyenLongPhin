package com.binzet.blog.service;

import com.binzet.blog.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    void delete(int id);
    Category findById(int id);
}
