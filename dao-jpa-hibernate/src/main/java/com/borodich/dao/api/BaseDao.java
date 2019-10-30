package com.borodich.dao.api;

import java.util.List;

import com.borodich.entity.api.AbstractBaseEntity;

public interface BaseDao<T extends AbstractBaseEntity> {

    public T findById(Integer id);

    public void saveAndFlush(T entity);

    public void update(T entity);

    public void delete(T entity);

    public List<T> findAll();
}
