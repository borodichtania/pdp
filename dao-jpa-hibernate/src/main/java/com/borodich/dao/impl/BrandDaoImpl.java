package com.borodich.dao.impl;

import com.borodich.dao.api.BrandDao;
import com.borodich.entity.Brand;
import com.borodich.entity.Brand_;

import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class BrandDaoImpl extends AbstractBaseDao<Brand> implements BrandDao {

    public BrandDaoImpl() {
	super(Brand.class);
    }

    @Override
    public Brand getBrandByTitle(String title) {
	CriteriaQuery<Brand> query = getCriteriaQuery();
	Root<Brand> brandRoot = query.from(Brand.class);
	query.where(getCriteriaBuilder().equal(brandRoot.get(Brand_.title), title));
	return getTypedQuery(query).getSingleResult();
    }
}