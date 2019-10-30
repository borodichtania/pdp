package com.borodich.service.api;

import com.borodich.entity.Product;

import java.util.List;

public interface ProductService extends BaseService<Product>{
    
    public List<Product> getProductsFromSection(String titleSection);

}
