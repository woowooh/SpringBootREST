package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.omg.po.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BlogService extends BaseService<Blog> {
    private static String IS_DELETE = "is_delete";
    private static Short NOT_DELETE = 0;

    @Autowired
    private CommentService commentService;

    public List<Blog> getBlogsAndComments(){
        QueryWrapper<Blog> condition = createCondition();
        condition.eq(IS_DELETE, NOT_DELETE);
        List<Blog> blogs = mapper.selectList(condition);
        blogs.forEach(
            blog -> blog.setComments(
                commentService.listByBlogId(blog.getId())
            )
        );
        return blogs;
    }
}
