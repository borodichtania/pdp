package com.borodich.service.api;

import com.borodich.entity.Vendor;

import java.util.List;

public interface VendorService extends BaseService<Vendor>{
    
    public List<Vendor> getFreeVendors();

}
