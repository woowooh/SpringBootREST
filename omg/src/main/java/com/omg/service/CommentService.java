package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.omg.dao.CommentDAO;
import com.omg.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public List<Comment> getComments(Long blogId){
        QueryWrapper query = new QueryWrapper<Comment>()
                                    .eq("blog_id", blogId)
                                    .eq("is_delete", 0);
        Page<Comment> page = new Page<>(1, 30);
        List<Comment> comments = commentDAO.selectPage(page, query).getRecords();
        return comments;
    }

    public void addComment(Comment comment){
        commentDAO.insert(comment);
    }

    public void updateComment(Comment comment){
        commentDAO.updateById(comment);
    }

    public Comment findComment(Long commentId) {
        Comment b = commentDAO.selectById(commentId);
        return b;
    }

    public void deleteComment(Long commentId) {
        commentDAO.deleteById(commentId);
    }
}
