package com.borodich.service.impl;

import com.borodich.dao.api.AdressDao;
import com.borodich.entity.Adress;
import com.borodich.service.api.AdressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressServiceImpl extends AbstractBaseService<Adress> implements AdressService{
    
    @Autowired
    private AdressDao adressDao;

    @Override
    public List<Adress> getListAdressByStreet(String street) {
	return adressDao.getListAdressByStreet(street);
    }
}