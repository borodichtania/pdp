package com.borodich.dao.api;

import com.borodich.entity.Vendor;

import java.util.List;

public interface VendorDao extends BaseDao<Vendor> {
    
    public List<Vendor> getFreeVendors();

}
