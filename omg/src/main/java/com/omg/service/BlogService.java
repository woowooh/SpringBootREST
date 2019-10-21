package com.omg.service;

import com.omg.dao.BlogDAO;
import com.omg.dao.CommentDAO;
import com.omg.po.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private CommentService commentService;

    public List<Blog> getBlogs(){
        List<Blog> blogs = blogDAO.selectList(null);
        blogs.forEach(
                blog -> blog.setComments(
                    commentService.getComments(blog.getId())
                )
        );
        return blogs;
    }

    public void addBlog(Blog blog){
        blogDAO.insert(blog);
    }

    public void updateBlog(Blog blog){
        blogDAO.updateById(blog);
    }

    public Blog findBlog(long blog_id) {
        Blog b = blogDAO.selectById(blog_id);
        return b;
    }

    public void deleteBlog(long blog_id) {
        blogDAO.deleteById(blog_id);
    }
}
