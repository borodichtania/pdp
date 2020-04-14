package com.borodich.service.api;

import com.borodich.entity.Chek;

import java.util.List;

public interface ChekService extends BaseService<Chek> {

    public List<Chek> getCheksByCustomer(Integer idCustomer);

    public List<Chek> getCheksBySum(String sum);

}
