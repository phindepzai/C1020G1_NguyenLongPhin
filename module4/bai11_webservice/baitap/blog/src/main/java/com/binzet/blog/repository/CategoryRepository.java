package com.binzet.blog.repository;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
