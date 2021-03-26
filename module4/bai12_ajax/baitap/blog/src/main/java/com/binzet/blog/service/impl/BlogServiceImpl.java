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
    public List<Blog> findAll(int page) {
        return getList(page,blogRepository.findAll());
    }

    @Override
    public List<Blog> findAllByCategory(int page, int id) {
        return getList(page,blogRepository.findALLByCategory(categoryService.findById(id)));
    }

    @Override
    public List<Blog> findAllByTitle(int page, String title) {
        return getList(page,blogRepository.findAllByTitleIsContaining(title));
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findBlogByOrderByDate(String title, int page, int type) {
        List<Blog> blogs;
        if (title != null){
            if (type == 2){
                blogs =  blogRepository.findAllByTittleAndOrderByDate(title);
            } else {
                blogs =  blogRepository.findAllByTittleAndOrderByDateDesc(title);
            }
        } else {
            if (type == 2){
                blogs =  blogRepository.findBlogByOrderByDate();
            } else {
                blogs =  blogRepository.findBlogByOrderByDateDesc();
            }
        }
        return getList(page, blogs);
    }

    private List<Blog> getList(int page, List<Blog> blogs) {
        List<Blog> re = new ArrayList<>();
        int size = page * 5;
        if (blogs.size() < size){
            return blogs;
        }
        for (int i = 0; i < size; i++) {
            re.add(blogs.get(i));
        }
        return re;
    }
}
