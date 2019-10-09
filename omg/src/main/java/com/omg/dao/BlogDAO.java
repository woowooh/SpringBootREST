package com.omg.dao;

import com.omg.po.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogDAO {
    void addOne(Blog blog);
    void updateOne(Blog blog);
    void deleteById(long blog_id);
    Blog findById(long blog_id);
    List<Blog> findAll();
}
