package com.borodich.service.impl;

import com.borodich.dao.api.ProductDao;
import com.borodich.entity.Product;
import com.borodich.service.api.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends AbstractBaseService<Product> implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProductsFromSection(String titleSection) {
	return productDao.getProductsFromSection(titleSection);
    }

}
