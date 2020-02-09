package com.omg.controller;

import com.omg.dto.Result;
import com.omg.po.Blog;
import com.omg.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogList")
    public List<Blog> blogList() {
        return blogService.getAll();
    }

    @PostMapping("/addBlog")
    public Result addBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        return Result.successResult();
    }

    @PostMapping("/updateBlog")
    public Result updateBlog(@RequestBody Blog blog) {
        blogService.updateById(blog);
        return Result.successResult();
    }

    @GetMapping("/blog/{blogId}")
    public Result getBlog(@PathVariable("blogId")Long blogId) {
        Blog b = blogService.findById(blogId);
        return Result.successResult(b);
    }

    @GetMapping("/deleteBlog/{blogId}")
    public Result deleteBlog(@PathVariable("blogId")Long blogId) {
        blogService.deleteById(blogId);
        return Result.successResult();
    }
}
