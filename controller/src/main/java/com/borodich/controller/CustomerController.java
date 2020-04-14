package com.borodich.controller;

import com.borodich.entity.Customer;
import com.borodich.service.api.CustomerService;
import com.borodich.service.exception.FreeVendorNotExist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController extends AbstractBaseController<Customer> {

    @Autowired
    private CustomerService customerService;

    @Override
    @GetMapping("customer/{id}")
    public Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Customer customer = customerService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customer);
	return result;
    }

    @Override
    @GetMapping("customers")
    public Map<String, Object> getEntities() {
	List<Customer> customers = customerService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customers);
	return result;
    }

    @Override
    @PostMapping("customer")
    public Map<String, Object> createEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.create(entity);
	result.put("result", "created");
	return result;
    }

    @Override
    @DeleteMapping("customer/{id}")
    public Map<String, Object> deleteEntity(@PathVariable Integer id) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.delete(id);
	result.put("result", "deleted");
	return result;
    }

    @Override
    @PutMapping("customer")
    public Map<String, Object> updateEntity(@RequestBody Customer entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	customerService.update(entity);
	result.put("result", entity);
	return result;
    }

    @PostMapping("customer/addChek")
    public Map<String, Object> addChek(@RequestParam(name = "customerId") Integer customerId,
	    @RequestParam(name = "productsId") List<Integer> productsId,
	    @RequestParam(name = "adressId") Integer adressId) throws FreeVendorNotExist {
	customerService.addChekToCustomer(customerId, productsId, adressId);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", "chek was added");
	return result;
    }
    
    @GetMapping("customer/maxSumInChek")
    public Map<String, Object> getCustomerWithMaxSumInChek() throws FreeVendorNotExist {
	Customer customer = customerService.getCustomerWithMaxSumInChek();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", customer);
	return result;
    } 
}