package com.borodich.service.api;

import com.borodich.entity.Brand;

public interface BrandService extends BaseService<Brand>{
    
    public Brand getBrandByTitle(String title);

}
