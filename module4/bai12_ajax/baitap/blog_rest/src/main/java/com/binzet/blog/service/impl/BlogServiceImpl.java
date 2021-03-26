package com.binzet.blog.service.impl;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.repository.BlogRepository;
import com.binzet.blog.service.BlogService;
import com.binzet.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    CategoryService categoryService;

    @Override
    public void save(Blog blog) {
        Date now = new Date();
        String nowStr = (now.getYear() + 1900) + "-" + (now.getMonth() + 1) + "-" + now.getDate();
        blog.setDate(nowStr);
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(Pageable pageable, int id) {
        return blogRepository.findALLByCategory(pageable,categoryService.findById(id));
    }

    @Override
    public Page<Blog> findAllByTitle(Pageable pageable, String title) {
        return blogRepository.findAllByTitleIsContaining(pageable,title);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> findBlogByOrderByDate(String title,Pageable pageable,int type) {
        Pageable page = null;
        if (title != null){
            page = findAllByTitle(pageable,title).getPageable();
            if (type == 2){
                return blogRepository.findAllByTittleAndOrderByDate(page,title);
            } else {
                return blogRepository.findAllByTittleAndOrderByDateDesc(page,title);
            }
        } else {
            page = pageable;
            if (type == 2){
                return blogRepository.findBlogByOrderByDate(page);
            } else {
                return blogRepository.findBlogByOrderByDateDesc(page);
            }
        }
    }
}
