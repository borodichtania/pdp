package com.borodich.dao.impl;

import com.borodich.dao.api.BaseDao;
import com.borodich.entity.api.AbstractBaseEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractBaseDao<T extends AbstractBaseEntity> implements BaseDao<T> {

    private String selectEntityQuery = "SELECT entity FROM %s entity";

    protected Class<T> clazz;
    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractBaseDao(Class<T> clazz) {
	this.clazz = clazz;
    }

    protected CriteriaBuilder getCriteriaBuilder() {
	return entityManager.getCriteriaBuilder();
    }

    protected CriteriaQuery<T> getCriteriaQuery() {
	return (CriteriaQuery<T>) getCriteriaBuilder().createQuery(clazz);
    }

    protected TypedQuery<T> getTypedQuery(CriteriaQuery<T> criteriaQuery) {
	return (TypedQuery<T>) entityManager.createQuery(criteriaQuery);
    }

    @Override
    public T findById(Integer id) {
	return entityManager.find(clazz, id);
    }

    @Override
    public void saveAndFlush(T entity) {
	entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
	entityManager.merge(entity);
	// entityManager.refresh(entity); // будут восстановлены все изменения
	// из базы данных данного Entity и всех каскадно зависимых объектов
    }

    @Override
    public void delete(T entity) {
	entity = entityManager.contains(entity) ? entity : entityManager.find(clazz, entity.getId());
	entityManager.remove(entity);
    }

    @Override
    public List<T> findAll() {
	String table = clazz.getSimpleName();
	String querySql = String.format(selectEntityQuery, table);
	TypedQuery<T> query = entityManager.createQuery(querySql, clazz);
	return query.getResultList();
    }
}