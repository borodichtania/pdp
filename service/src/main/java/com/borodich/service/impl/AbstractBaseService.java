package com.borodich.service.impl;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;
import com.borodich.service.api.BaseService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
public abstract class AbstractBaseService<T extends AbstractBaseEntity> implements BaseService<T> {

    @Autowired
    private BaseDao<T> dao;

    @Override
    public void create(T entity) {
	dao.saveAndFlush(entity);
    }

    @Override
    public void update(T entity) {
	dao.update(entity);
    }

    @Override
    public void delete(Integer id) {
	dao.delete(dao.findById(id));
    }

    @Override
    public T getById(Integer id) {
	return (T) dao.findById(id);
    }

    @Override
    public List<T> getAll() {
	return (List<T>) dao.findAll();
    }
}