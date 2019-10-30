package com.borodich.dao.impl;

import com.borodich.dao.api.VendorDao;
import com.borodich.entity.Vendor;
import com.borodich.entity.Vendor_;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class VendorDaoImpl extends AbstractBaseDao<Vendor> implements VendorDao {

    public VendorDaoImpl() {
	super(Vendor.class);
    }

    @Override
    public List<Vendor> getFreeVendors() {
	CriteriaQuery<Vendor> query = getCriteriaQuery();
	Root<Vendor> vendorRoot = query.from(Vendor.class);
	query.select(vendorRoot).where(getCriteriaBuilder().equal(vendorRoot.get(Vendor_.status), 0));
	
	List<Vendor> vendors = getTypedQuery(query).getResultList();
	return vendors;
    }
}