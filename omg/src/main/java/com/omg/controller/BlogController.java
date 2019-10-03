package com.omg.controller;

import com.omg.po.Blog;
import com.omg.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogList")
    public List<Blog> blogList() {
        return blogService.getBlogs();
    }

    @PostMapping("/addBlog")
    public void addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
    }

    @GetMapping("/blog/{blogId}")
    public Blog getBlog(@PathVariable("blogId")long blogId) {
        Blog b = blogService.findBlog(blogId);
        return b;
    }
}
