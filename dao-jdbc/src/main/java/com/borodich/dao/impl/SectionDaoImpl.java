package com.borodich.dao.impl;

import com.borodich.dao.api.SectionDao;
import com.borodich.entity.Section;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectionDaoImpl extends AbstractBaseDao<Section> implements SectionDao {

    public SectionDaoImpl() {
	super(Section.class);
    }

    @Override
    public Section findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void saveAndFlush(Section entity) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void update(Section entity) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void delete(Section entity) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public List<Section> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
