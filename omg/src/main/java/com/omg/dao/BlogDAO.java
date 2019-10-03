package com.omg.dao;

import com.omg.po.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BlogDAO {
    void addOne(Blog blog);
    Blog findById(long id);
    List<Blog> findAll();
}
