package com.borodich.dao.impl;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractBaseDao<T extends AbstractBaseEntity> implements BaseDao<T> {

    protected Class<T> clazz;
    
    @Autowired
    protected JdbcTemplate jdbcTemplate;
   
    public AbstractBaseDao(Class<T> clazz) {
	this.clazz = clazz;
    }
}