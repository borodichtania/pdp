package com.borodich.dao.impl;

import com.borodich.dao.api.CustomerDao;
import com.borodich.entity.Customer;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoImpl extends AbstractBaseDao<Customer> implements CustomerDao {

    public CustomerDaoImpl() {
	super(Customer.class);
    }
    
    class CustomerRowMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Customer customer = new Customer();
	    customer.setId(rs.getInt("id"));
	    customer.setName(rs.getString("name"));
	    customer.seteMail(rs.getString("email"));
	    customer.setPhone(rs.getString("phone"));
	    return customer;
	}
    }

    @Override
    public Customer getCustomerWithMaxSumInChek() {

	return null;
    }

    @Override
    public Customer findById(Integer id) {
	return jdbcTemplate.queryForObject("select * from customer where id=?", new Object[] { id }, new CustomerRowMapper());
    }

    @Override
    public void saveAndFlush(Customer entity) {
	// TODO Auto-generated method stub
    }

    @Override
    public void update(Customer entity) {
	// TODO Auto-generated method stub
    }

    @Override
    public void delete(Customer entity) {
	// TODO Auto-generated method stub
    }

    @Override
    public List<Customer> findAll() {
	// TODO Auto-generated method stub
	return null;
    }
}