package com.omg.service;

import com.omg.po.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService extends BaseService<Blog> {
    @Autowired
    private CommentService commentService;

    public List<Blog> getBlogsAndComments(){
        List<Blog> blogs = mapper.selectList(null);
        blogs.forEach(
                blog -> blog.setComments(
                    commentService.listByBlogId(blog.getId())
                )
        );
        return blogs;
    }
}
