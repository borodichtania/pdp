package com.borodich.controller;

import com.borodich.entity.Chek;
import com.borodich.service.api.ChekService;

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
public class ChekController extends AbstractBaseController<Chek>{

    @Autowired
    private ChekService chekService;

    @Override
    @GetMapping("chek/{id}")
    public Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Chek chek = chekService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", chek);
	return result;
    }

    @Override
    @GetMapping("cheks")
    public Map<String, Object> getEntities() {
	List<Chek> cheks = chekService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", cheks);
	return result;
    }

    @Override
    @PostMapping("chek")
    public Map<String, Object> createEntity(@RequestBody Chek entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", "can not created");
	return result;
    }

    @Override
    @DeleteMapping("chek/{id}")
    public Map<String, Object> deleteEntity(@PathVariable Integer id) {
	chekService.delete(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", "deleted");
	return result;
    }

    @Override
    @PutMapping("chek/")
    public Map<String, Object> updateEntity(@RequestBody Chek entity) {
	chekService.update(entity);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", entity);
	return result;
    }
    
    @GetMapping("chekByCustomer/{id}")
    public Map<String, Object> getCeksByCustomer(@PathVariable(ID) Integer idCustomer){
	List<Chek> cheks = chekService.getCheksByCustomer(idCustomer);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", cheks);
	return result;
    }
    
    @GetMapping("chekBySum/{sum}")
    public Map<String, Object> getCeksBySum(@PathVariable("sum") String sum){
	List<Chek> cheks = chekService.getCheksBySum(sum);
	Map<String, Object> result = new HashMap<String, Object>();	
	result.put("result", cheks);
	return result;
    }
}
