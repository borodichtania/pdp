package com.borodich.controller;

import com.borodich.entity.Vendor;
import com.borodich.service.api.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VendorController extends AbstractBaseController<Vendor>{
    
    @Autowired
    private VendorService vendorService;

    @Override
    @GetMapping("vendor/{id}")
    public Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Vendor vendor = vendorService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", vendor);
	return result;
    }
    
    @Override
    @GetMapping("vendors")
    public Map<String, Object> getEntities() {
	List<Vendor> vendor = vendorService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", vendor);
	return result;
    }

    @Override
    @PostMapping("vendor")
    public Map<String, Object> createEntity(@RequestBody Vendor entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	vendorService.create(entity);
	result.put("result", "created");
	return result;
    }

    @Override
    @DeleteMapping("vendor/{id}")
    public Map<String, Object> deleteEntity(@PathVariable Integer id) {
	Map<String, Object> result = new HashMap<String, Object>();
	vendorService.delete(id);
	result.put("result", "deleted");
	return result;
    }

    @Override
    @PutMapping("vendor")
    public Map<String, Object> updateEntity(@RequestBody Vendor entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	vendorService.update(entity);
	result.put("result", entity);
	return result;
    }
    
    @GetMapping("vendor/free")
    public Map<String, Object> getFreeVendors() {
	Map<String, Object> result = new HashMap<String, Object>();
	List<Vendor> freeVendors = vendorService.getFreeVendors();
	result.put("result", freeVendors);
	return result;
    }
}