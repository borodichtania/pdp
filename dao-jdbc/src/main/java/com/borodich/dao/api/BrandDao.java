package com.borodich.dao.api;

import com.borodich.entity.Brand;

public interface BrandDao extends BaseDao<Brand>{
    
    public Brand getBrandByTitle(String title);

}
