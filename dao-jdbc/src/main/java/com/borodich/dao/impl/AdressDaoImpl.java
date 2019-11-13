package com.borodich.dao.impl;

import com.borodich.dao.api.AdressDao;
import com.borodich.entity.Adress;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdressDaoImpl extends AbstractBaseDao<Adress> implements AdressDao {
    
    private RowMapper<Adress> rowMapper = new AdressRowMapper();

    public AdressDaoImpl() {
	super(Adress.class);
    }

    class AdressRowMapper implements RowMapper<Adress> {
	@Override
	public Adress mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Adress adress = new Adress();
	    adress.setId(rs.getInt("id"));
	    adress.setApartment(rs.getString("apartment"));
	    adress.setCity(rs.getString("city"));
	    adress.setHouse(rs.getString("house"));
	    adress.setStreet(rs.getString("street"));
	    return adress;
	}
    }

    @Override
    public List<Adress> getListAdressByStreet(String street) {
	return jdbcTemplate.queryForList("select * from adress where street = ?", clazz, street);
    }

    @Override
    public Adress findById(Integer id) {
	return jdbcTemplate.queryForObject("select * from adress where id=?", new Object[] { id },
		rowMapper);
    }

    @Override
    public void saveAndFlush(Adress entity) {
	jdbcTemplate.update("insert into adress (id, city, street, house, apartment) values (?,?,?,?,?)", new Object[] {
	        entity.getId(), entity.getCity(), entity.getStreet(), entity.getHouse(), entity.getApartment() });
    }

    @Override
    public void update(Adress entity) {
	jdbcTemplate.update(
	        "update adress set city =?, street =?, house =?, apartment =?  where id =?",
	        new Object[] { entity.getCity(), entity.getStreet(), entity.getHouse(), entity.getApartment(),
	                entity.getId() });
    }

    @Override
    public void delete(Adress entity) {
	jdbcTemplate.update("delete from adress where id=?", new Object[] { entity.getId() });
    }

    @Override
    public List<Adress> findAll() {
	return jdbcTemplate.query("select * from adress", rowMapper);
    }
}