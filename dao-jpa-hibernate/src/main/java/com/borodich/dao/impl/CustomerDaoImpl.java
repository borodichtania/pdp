package com.borodich.dao.impl;

import com.borodich.dao.api.CustomerDao;
import com.borodich.entity.Chek;
import com.borodich.entity.Chek_;
import com.borodich.entity.Customer;
import com.borodich.entity.Customer_;

import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Repository
public class CustomerDaoImpl extends AbstractBaseDao<Customer> implements CustomerDao {

    public CustomerDaoImpl() {
	super(Customer.class);
    }

    @Override
    public Customer getCustomerWithMaxSumInChek() {
	CriteriaQuery<Customer> query = getCriteriaQuery();
	Root<Customer> customerRoot = query.from(Customer.class);
	
	Join<Customer, Chek> join = customerRoot.join(Customer_.cheks);
	Subquery<Double> subquery = query.subquery(Double.class);
	Root<Chek> chekRoot = subquery.from(Chek.class);
	subquery.select(getCriteriaBuilder().max(chekRoot.get(Chek_.sum)));
	
	query.where(getCriteriaBuilder().equal(join.get(Chek_.sum), subquery.getSelection()));
	return getTypedQuery(query).getSingleResult();
    }
}