package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

public interface IBaseService<T> {
    T findById(Long id);

    void save(T obj);

    int deleteById(Long id);

    void updateById(T obj);

    List<T> getAll();

    List<T> listPageByCondition(Page page, QueryWrapper condition);

    List<T> listByCondition(QueryWrapper condition);
}