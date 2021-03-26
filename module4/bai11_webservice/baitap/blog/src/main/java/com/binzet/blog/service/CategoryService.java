package com.binzet.blog.service;

import com.binzet.blog.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
}
