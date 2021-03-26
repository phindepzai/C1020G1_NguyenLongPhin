package com.binzet.blog.service;

import com.binzet.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    void saveCategory(Category category);

    void deleteCategory(Integer id);

    Category findCategoryById(Integer id);

}