package com.binzet.blog.service.impl;

import com.binzet.blog.entity.Blog;
import com.binzet.blog.repository.BlogRepository;
import com.binzet.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
       return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findBlogById(Integer id) {
        return blogRepository.findById( id );
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById( id );
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save( blog );
    }

    @Override
    public Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable) {
      return blogRepository.findBlogByCategory_Id( id,pageable );
    }

    @Override
    public Page<Blog> findBlogByNameContains(String search, Pageable pageable) {
        return blogRepository.findBlogByTitleContains( search,pageable );
    }

    @Override
    public Page<Blog> findBlogByOrderByDateAsc(Pageable pageable) {
        return blogRepository.findBlogByOrderByDateAsc( pageable );
    }


}