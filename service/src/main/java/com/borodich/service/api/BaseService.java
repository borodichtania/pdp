package com.borodich.service.api;

import java.util.List;

import com.borodich.entity.api.AbstractBaseEntity;

public interface BaseService<T extends AbstractBaseEntity> {
	
	public void create(T entity);

	public void update(T entity);

	public void delete(Integer id);

	public T getById(Integer id);

	public List<T> getAll();
}