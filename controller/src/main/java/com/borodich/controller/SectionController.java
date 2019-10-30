package com.borodich.controller;

import com.borodich.entity.Section;
import com.borodich.service.api.SectionService;

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
public class SectionController extends AbstractBaseController<Section>{
    
    @Autowired
    private SectionService sectionService;

    @Override
    @GetMapping("section/{id}")
    public Map<String, Object> getEntityById(@PathVariable(ID) Integer id) {
	Section section = sectionService.getById(id);
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", section);
	return result;
    }

    @Override
    @GetMapping("sections")
    public Map<String, Object> getEntities() {
	List<Section> sections = sectionService.getAll();
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("result", sections);
	return result;
    }

    @Override
    @PostMapping("section")
    public Map<String, Object> createEntity(@RequestBody Section entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	sectionService.create(entity);
	result.put("result", "created");
	return result;
    }

    @Override
    @DeleteMapping("section/{id}")
    public Map<String, Object> deleteEntity(@PathVariable Integer id) {
	Map<String, Object> result = new HashMap<String, Object>();
	sectionService.delete(id);
	result.put("result", "deleted");
	return result;
    }

    @Override
    @PutMapping("section")
    public Map<String, Object> updateEntity(@RequestBody Section entity) {
	Map<String, Object> result = new HashMap<String, Object>();
	sectionService.update(entity);
	result.put("result", entity);
	return result;
    }
}