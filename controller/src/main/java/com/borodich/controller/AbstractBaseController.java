package com.borodich.controller;

import com.borodich.entity.api.AbstractBaseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(value = "e-shop", produces = "application/json")
public abstract class AbstractBaseController<T extends AbstractBaseEntity>{

    protected static final String ID = "id";
    
    public abstract Map<String, Object> getEntityById(@PathVariable(ID) Integer id);
    public abstract Map<String, Object> getEntities();
    public abstract Map<String, Object> createEntity(@RequestBody T entity);
    public abstract Map<String, Object> deleteEntity(@RequestBody Integer id);
    public abstract Map<String, Object> updateEntity(@RequestBody T entity);
}