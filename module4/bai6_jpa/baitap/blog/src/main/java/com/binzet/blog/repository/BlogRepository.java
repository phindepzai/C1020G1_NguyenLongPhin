package com.binzet.blog.repository;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findALLByCategory(Pageable pageable,Category category);
    Page<Blog> findAllByTitleIsContaining(Pageable pageable,String title);
    Page<Blog> findBlogByOrderByDate(Pageable pageable);
    Page<Blog> findBlogByOrderByDateDesc(Pageable pageable);
    @Query("select b from blog b where b.title like %:title% order by b.date asc")
    Page<Blog> findAllByTittleAndOrderByDate(Pageable page,String title);
    @Query("select b from blog b where b.title like %:title% order by b.date desc")
    Page<Blog> findAllByTittleAndOrderByDateDesc(Pageable page,String title);
}
