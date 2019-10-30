package com.borodich.dao.impl;

import com.borodich.dao.api.SectionDao;
import com.borodich.entity.Section;

import org.springframework.stereotype.Repository;

@Repository
public class SectionDaoImpl extends AbstractBaseDao<Section> implements SectionDao {

    public SectionDaoImpl() {
	super(Section.class);
    }

}
