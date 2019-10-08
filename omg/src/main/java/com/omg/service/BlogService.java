package com.omg.service;

import com.omg.dao.BlogDAO;
import com.omg.po.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogDAO blogDAO;

    public List<Blog> getBlogs(){
        List<Blog> blogs = blogDAO.findAll();
        return blogs;
    }

    public void addBlog(Blog blog){
        blogDAO.addOne(blog);
    }

    public void updateBlog(Blog blog){
        blogDAO.updateOne(blog);
    }

    public Blog findBlog(long blog_id) {
        Blog b = blogDAO.findById(blog_id);
        return b;
    }

    public void deleteBlog(long blog_id) {
        blogDAO.deleteById(blog_id);
    }
}
