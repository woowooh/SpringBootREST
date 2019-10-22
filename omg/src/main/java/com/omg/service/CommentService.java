package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.omg.po.Comment;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService extends BaseService<Comment> {
    public List<Comment> listByBlogId(Long blogId) {
        QueryWrapper condition = new QueryWrapper<Comment>();
        condition.eq("blog_id", blogId);
        Page page = new Page(1, 20);
        List comments = listPageByCondition(page, condition);
        return comments;
    }
}
