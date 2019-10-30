package com.borodich.controller;

import com.borodich.entity.Adress;
import com.borodich.service.api.AdressService;

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
public class AdressController extends AbstractBaseController<Adress> {

    @Autowired
    private AdressService adressService;

    @Override
    @GetMapping("adress/{id}")
    public Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Adress adress = adressService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", adress);
	return result;
    }

    @Override
    @GetMapping("adresses")
    public Map<String, Object> getEntities() {
	List<Adress> adresses = adressService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", adresses);
	return result;
    }

    @Override
    @PostMapping("adress")
    public Map<String, Object> createEntity(@RequestBody Adress entity) {
	adressService.create(entity);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", "created");
	return result;
    }

    @Override
    @DeleteMapping("adress/{id}")
    public Map<String, Object> deleteEntity(@PathVariable Integer id) {
	adressService.delete(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", "removed");
	return result;
    }

    @Override
    @PutMapping("adress")
    public Map<String, Object> updateEntity(@RequestBody Adress entity) {
	adressService.update(entity);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", entity);
	return result;
    }

    @GetMapping("adress")
    public Map<String, Object> getListAdressesByStreet(@RequestParam String street) {
	Map<String, Object> result = new HashMap<String, Object>();
	List<Adress> adresses = adressService.getListAdressByStreet(street);
	result.put("result", adresses);
	return result;
    }
}