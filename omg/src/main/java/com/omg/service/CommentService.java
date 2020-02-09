package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.omg.po.Comment;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService extends BaseService<Comment> {
    private static String BLOG_ID = "blog_id";
    private static String IS_DELETE = "is_delete";
    private static Short NOT_DELETE = 0;

    public List<Comment> listByBlogId(Long blogId) {
        QueryWrapper<Comment> condition = createCondition();
        condition.eq(BLOG_ID, blogId)
                 .eq(IS_DELETE, NOT_DELETE);
        Page page = new Page(1, 20);
        List comments = listPageByCondition(page, condition);
        return comments;
    }
}
