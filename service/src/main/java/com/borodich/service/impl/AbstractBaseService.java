package com.borodich.service.impl;

import com.borodich.dao.api.BaseDaoRepository;
import com.borodich.entity.api.AbstractBaseEntity;
import com.borodich.service.api.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
@Service
public abstract class AbstractBaseService<T extends AbstractBaseEntity> implements BaseService<T> {

    @Autowired
    private BaseDaoRepository<T> dao;

    @Override
    public void create(T entity) {
	dao.save(entity);
    }

    @Override
    public void update(T entity) {
	dao.save(entity);
    }

    @Override
    public void delete(Integer id) {
	dao.delete(dao.findById(id).get());
    }

    @Override
    public T getById(Integer id) {
	return (T) dao.findById(id).get();
    }

    @Override
    public List<T> getAll() {
	return (List<T>) dao.findAll();
    }
}