package com.borodich.dao.api;

import com.borodich.entity.Adress;

import java.util.List;

public interface AdressDao extends BaseDao<Adress>{
    
    public List<Adress> getListAdressByStreet(String street);

}
