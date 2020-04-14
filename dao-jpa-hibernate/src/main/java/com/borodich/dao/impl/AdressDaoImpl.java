package com.borodich.dao.impl;

import com.borodich.dao.api.AdressDao;
import com.borodich.entity.Adress;
import com.borodich.entity.Adress_;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class AdressDaoImpl extends AbstractBaseDao<Adress> implements AdressDao {

    public AdressDaoImpl() {
	super(Adress.class);
    }

    @Override
    public List<Adress> getListAdressByStreet(String street) {
	CriteriaQuery<Adress> query = getCriteriaQuery();
	Root<Adress> adressRoot = query.from(Adress.class);
	query.where(getCriteriaBuilder().equal(adressRoot.get(Adress_.street), street));
	return getTypedQuery(query).getResultList();
    }
}