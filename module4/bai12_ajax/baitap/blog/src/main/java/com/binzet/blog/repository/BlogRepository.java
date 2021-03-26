package com.binzet.blog.repository;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findALLByCategory(Category category);
    List<Blog> findAllByTitleIsContaining(String title);
    List<Blog> findBlogByOrderByDate();
    List<Blog> findBlogByOrderByDateDesc();
    @Query("select b from blog b where b.title like %:title% order by b.date asc")
    List<Blog> findAllByTittleAndOrderByDate(String title);
    @Query("select b from blog b where b.title like %:title% order by b.date desc")
    List<Blog> findAllByTittleAndOrderByDateDesc(String title);
}
