package com.borodich.dao.api;

import com.borodich.entity.Customer;

public interface CustomerDao extends BaseDao<Customer> {
    
    public Customer getCustomerWithMaxSumInChek();

}
