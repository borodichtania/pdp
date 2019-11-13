package com.borodich.dao.impl;

import com.borodich.dao.api.VendorDao;
import com.borodich.dao.impl.ProductDaoImpl.ProductRowMapper;
import com.borodich.entity.Customer;
import com.borodich.entity.Vendor;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VendorDaoImpl extends AbstractBaseDao<Vendor> implements VendorDao {

    public VendorDaoImpl() {
	super(Vendor.class);
    }
    
    class VendorRowMapper implements RowMapper<Vendor> {
	@Override
	public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Vendor vendor = new Vendor();
	    vendor.setId(rs.getInt("id"));
	    vendor.setName(rs.getString("name"));
	    vendor.setStatus(rs.getBoolean("status"));
	    vendor.setPhone(rs.getString("phone"));
	    return vendor;
	}
    }

    @Override
    public List<Vendor> getFreeVendors() {
	return jdbcTemplate.query("select * from vendor where status=0", new VendorRowMapper());
    }

    @Override
    public Vendor findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void saveAndFlush(Vendor entity) {
	jdbcTemplate.update("insert into vendor (name, status, phone) values (?,?,?)", new Object[]{entity.getName(), entity.getStatus(), entity.getPhone()});
	
    }

    @Override
    public void update(Vendor entity) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void delete(Vendor entity) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public List<Vendor> findAll() {
	// TODO Auto-generated method stub
	return null;
    }
}