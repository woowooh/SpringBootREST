package com.omg.dao;

import com.omg.po.Blog;
import com.omg.po.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDAO {
    void addOne(Blog blog);
    void updateOne(Blog blog);
    void deleteById(Long blogId);
    Blog findById(Long blogId);
    List<Blog> findAll();
    List<Comment> getCommentsById(Long blogId);
}
