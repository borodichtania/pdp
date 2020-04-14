package com.borodich.dao.api;

import com.borodich.entity.Adress;
import com.borodich.entity.Chek;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;
import com.borodich.entity.Vendor;

import java.util.List;

public interface ChekDao extends BaseDao<Chek> {

    public Chek prepareNewChek(Double sum, Customer customer, List<Product> products, Vendor vendor, Adress adress);

    public List<Chek> getCheksByCustomer(Integer idCustomer);
    
    public List<Chek> getCheksBySum(String sum); 

}
