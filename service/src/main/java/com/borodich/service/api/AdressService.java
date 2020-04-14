package com.borodich.service.api;

import com.borodich.entity.Adress;

import java.util.List;

public interface AdressService extends BaseService<Adress>{
    
    public List<Adress> getListAdressByStreet(String street);

}
