package com.borodich.dao.impl;

import com.borodich.dao.api.BrandDao;
import com.borodich.entity.Brand;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDaoImpl extends AbstractBaseDao<Brand> implements BrandDao {

    public BrandDaoImpl() {
	super(Brand.class);
    }

    @Override
    public Brand getBrandByTitle(String title) {
	return null;
    }

    @Override
    public Brand findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void saveAndFlush(Brand entity) {
	// TODO Auto-generated method stub
    }

    @Override
    public void update(Brand entity) {
	// TODO Auto-generated method stub
    }

    @Override
    public void delete(Brand entity) {
	// TODO Auto-generated method stub
    }

    @Override
    public List<Brand> findAll() {
	// TODO Auto-generated method stub
	return null;
    }
}