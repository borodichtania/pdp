package com.borodich.dao.api;

import com.borodich.entity.Product;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {
    public List<Product> getProductsFromSection(String titleSection);

}
