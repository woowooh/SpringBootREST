package com.omg.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

public interface IBaseService<T> {
    T findById(Long id);

    int save(T obj);

    int deleteById(Long id);

    int updateById(T obj);

    List<T> getAll();

    List<T> listPageByCondition(Page page, QueryWrapper condition);

    List<T> listByCondition(QueryWrapper condition);
}