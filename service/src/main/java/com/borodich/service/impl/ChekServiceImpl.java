package com.borodich.service.impl;

import com.borodich.dao.api.ChekDao;
import com.borodich.entity.Chek;
import com.borodich.service.api.ChekService;
import com.borodich.service.exception.ChekIsNotPaid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChekServiceImpl extends AbstractBaseService<Chek> implements ChekService {
    @Autowired
    private ChekDao chekDao;
    
    @Override
    public void delete(Integer id) throws ChekIsNotPaid {
	Chek chek = chekDao.findById(id);
	if (!chek.isPaid()) {
	    throw new ChekIsNotPaid();
	}
	chek.getVendor().setStatus(false);
	chekDao.delete(chek);
    }

    @Override
    public List<Chek> getCheksByCustomer(Integer idCustomer) {
	return chekDao.getCheksByCustomer(idCustomer);
    }

    @Override
    public List<Chek> getCheksBySum(String sum) {
	return chekDao.getCheksBySum(sum);
    }
}
