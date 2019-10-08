package com.omg.controller;

import com.omg.dto.Result;
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
    public Result addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return Result.successResult();
    }

    @PostMapping("/updateBlog")
    public Result updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return Result.successResult();
    }

    @GetMapping("/blog/{blogId}")
    public Result getBlog(@PathVariable("blogId")long blogId) {
        Blog b = blogService.findBlog(blogId);
        return Result.successResult(b);
    }

    @GetMapping("/deleteBlog/{blogId}")
    public Result deleteBlog(@PathVariable("blogId")long blogId) {
        blogService.deleteBlog(blogId);
        return Result.successResult();
    }
}
