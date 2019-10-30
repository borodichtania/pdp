package com.borodich.service.impl;


import com.borodich.dao.api.BrandDao;
import com.borodich.entity.Brand;
import com.borodich.service.api.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends AbstractBaseService<Brand> implements BrandService{
    
    @Autowired
    private BrandDao brandDao;

    @Override
    public Brand getBrandByTitle(String title) {
	return brandDao.getBrandByTitle(title);
    }

}
