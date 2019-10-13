package com.omg.dao;

import com.omg.po.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDAO {
    void addOne(Comment comment);
    void updateOne(Comment comment);
    void deleteById(Long commentId);
    Comment findById(Long commentId);
    List<Comment> findAll();
    List<Comment> listByBlogId(Long blogId);
}
