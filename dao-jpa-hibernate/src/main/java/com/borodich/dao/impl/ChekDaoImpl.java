package com.borodich.dao.impl;

import com.borodich.dao.api.ChekDao;
import com.borodich.entity.Adress;
import com.borodich.entity.Chek;
import com.borodich.entity.Chek_;
import com.borodich.entity.Customer;
import com.borodich.entity.Customer_;
import com.borodich.entity.Product;
import com.borodich.entity.Vendor;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Repository
public class ChekDaoImpl extends AbstractBaseDao<Chek> implements ChekDao {

    private static final String CHEK = "chek";

    public ChekDaoImpl() {
	super(Chek.class);
    }

    @Override
    public Chek prepareNewChek(Double sum, Customer customer, List<Product> products, Vendor vendor, Adress adress) {
	Chek chek = new Chek(generatedNumber(), false, new Date(), sum, customer, products, vendor, adress);
	return chek;
    }

    private String generatedNumber() {
	List<Chek> cheks = findAll();
	if (CollectionUtils.isEmpty(cheks)){
	    return CHEK + 1;
	}
	Chek chek = cheks.get(cheks.size() - 1);
	String chekNumber = chek.getNumber();
	String number = CHEK + String.valueOf(Integer.valueOf(chekNumber.substring(4)) + 1);
	return number;
    }

    @Override
    public List<Chek> getCheksByCustomer(Integer idCustomer) {
	CriteriaQuery<Chek> query = getCriteriaQuery();
	Root<Chek> chekRoot = query.from(Chek.class);
	
	Subquery<Integer> subquery = query.subquery(Integer.class);
	Root<Customer> customers = subquery.from(Customer.class);
	Join<Customer, Chek> subqueryCustomer = customers.join(Customer_.cheks);
	
	subquery.select(subqueryCustomer.get(Chek_.id)).where(getCriteriaBuilder().and(getCriteriaBuilder().equal(customers.get(Customer_.id), idCustomer)));
	query.where(getCriteriaBuilder().in(chekRoot.get(Chek_.id)).value(subquery));
	List<Chek> cheks = getTypedQuery(query).getResultList();
	return cheks;
    }

    @Override
    public List<Chek> getCheksBySum(String sum) {
	CriteriaQuery<Chek> query = getCriteriaQuery();
	Root<Chek> chekRoot = query.from(Chek.class);

	query.where(getCriteriaBuilder().equal(chekRoot.get(Chek_.sum), sum));
	List<Chek> cheks = getTypedQuery(query).getResultList();
	return cheks;
    }
}