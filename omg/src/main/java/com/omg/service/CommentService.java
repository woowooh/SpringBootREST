package com.omg.service;

import com.omg.dao.CommentDAO;
import com.omg.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentDAO commentDAO;

    public List<Comment> getComments(){
        List<Comment> comments = commentDAO.findAll();
        return comments;
    }

    public void addComment(Comment comment){
        commentDAO.addOne(comment);
    }

    public void updateComment(Comment comment){
        commentDAO.updateOne(comment);
    }

    public Comment findComment(Long commentId) {
        Comment b = commentDAO.findById(commentId);
        return b;
    }

    public void deleteComment(Long commentId) {
        commentDAO.deleteById(commentId);
    }
}
