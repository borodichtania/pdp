package com.borodich.service.api;

import com.borodich.entity.Customer;
import com.borodich.service.exception.FreeVendorNotExist;

import java.util.List;

public interface CustomerService extends BaseService<Customer>{
    
    public void addChekToCustomer(Integer customer, List<Integer> products, Integer adress) throws FreeVendorNotExist;
    
    public Customer getCustomerWithMaxSumInChek();

}
