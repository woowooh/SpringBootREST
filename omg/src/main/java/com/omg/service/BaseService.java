package com.omg.service;

import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T> implements IBaseService<T> {
    @Autowired
    BaseMapper<T> mapper;

    public T findById(Long id) {
        return mapper.selectById(id);
    }

    public void save(T obj) {
        mapper.insert(obj);
    }

    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    public void updateById(T o) {
        mapper.updateById(o);
    }

    public List<T> getAll() {
        return mapper.selectList(null);
    }

    public List<T> listPageByCondition(Page page, QueryWrapper condition) {
        return mapper.selectPage(page, condition).getRecords();
    }

    public List<T> listByCondition(QueryWrapper condition) {
        return mapper.selectList(condition);
    }
}