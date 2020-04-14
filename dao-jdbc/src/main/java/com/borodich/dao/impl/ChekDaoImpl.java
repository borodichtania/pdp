package com.borodich.dao.impl;

import com.borodich.dao.api.ChekDao;
import com.borodich.entity.Adress;
import com.borodich.entity.Chek;
import com.borodich.entity.Customer;
import com.borodich.entity.Product;
import com.borodich.entity.Vendor;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ChekDaoImpl extends AbstractBaseDao<Chek> implements ChekDao {

    private static final String CHEK = "chek";
    private RowMapper<Chek> rowMapper = new ChekRowMapper();

    public ChekDaoImpl() {
	super(Chek.class);
    }

    class ChekRowMapper implements RowMapper<Chek> {
	@Override
	public Chek mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Chek chek = new Chek();
	    chek.setId(rs.getInt("id"));
	    chek.setNumber(rs.getString("number"));
	    chek.setIsPaid(rs.getBoolean("is_paid"));
	    chek.setDateStart(rs.getDate("date_start"));
	    chek.setDateFinish(rs.getDate("date_finish"));
	    chek.setSum(rs.getDouble("sum"));
	    return chek;
	}
    }

    @Override
    public Chek prepareNewChek(Double sum, Customer customer, List<Product> products, Vendor vendor, Adress adress) {
	Chek chek = new Chek(generatedNumber(), false, new Date(), sum, customer, products, vendor, adress);
	return chek;
    }

    private String generatedNumber() {
	List<Chek> cheks = findAll();
	if (CollectionUtils.isEmpty(cheks)) {
	    return CHEK + 1;
	}
	Chek chek = cheks.get(cheks.size() - 1);
	String chekNumber = chek.getNumber();
	String number = CHEK + String.valueOf(Integer.valueOf(chekNumber.substring(4)) + 1);
	return number;
    }

    @Override
    public List<Chek> getCheksByCustomer(Integer idCustomer) {
	return jdbcTemplate.query("select * from chek where customer_fk = ?", rowMapper, idCustomer);
    }

    @Override
    public List<Chek> getCheksBySum(String sum) {
	return jdbcTemplate.query("select * from chek where sum = ?", rowMapper, sum);
    }

    @Override
    public Chek findById(Integer id) {
	return jdbcTemplate.queryForObject("select * from chek where id = ?", rowMapper, id);
    }

    @Override
    public void saveAndFlush(final Chek entity) {
	jdbcTemplate
	        .update("insert into chek (id, number, is_paid, date_start, date_finish, sum, adress_fk, customer_fk, vendor_fk) values (?,?,?,?,?,?,?,?,?);",
	                new Object[] { entity.getId(), entity.getNumber(), entity.isPaid(), entity.getDateStart(),
	                        entity.getDateFinish(), entity.getSum(), entity.getAdress().getId(),
	                        entity.getCustomer().getId(), entity.getVendor().getId() });

	final Chek chek = jdbcTemplate.queryForObject("select * from chek order by id desc limit 1",
		rowMapper);

	final List<Product> products = entity.getProducts();
	jdbcTemplate.batchUpdate("insert into chek_has_product(chek_fk, product_fk) values (?,?)",
	        new BatchPreparedStatementSetter() {

		    @Override
		    public void setValues(PreparedStatement ps, int i) throws SQLException {
		        Product product = products.get(i);
		        ps.setObject(1, chek.getId());
		        ps.setObject(2, product.getId());
		    }

		    @Override
		    public int getBatchSize() {
		        return products.size();
		    }
	        });
	jdbcTemplate.update("update vendor set status = 1 where id =?", new Object[] { entity.getVendor().getId() });
    }

    @Override
    public void update(Chek entity) {
	jdbcTemplate
	        .update("update check set number=?, is_paid=?, date_start=?, date_finish=?, sum=?, adress_fk=?, customer_fk=?, vendor_fk =?  where id =?",
	                new Object[] { entity.getNumber(), entity.isPaid(), entity.getDateStart(),
	                        entity.getDateFinish(), entity.getSum(), entity.getAdress(), entity.getCustomer(),
	                        entity.getVendor(), entity.getId() });
    }

    @Override
    public void delete(Chek entity) {
	jdbcTemplate.update("delete from chek where id=?", new Object[] { entity.getId() });
    }

    @Override
    public List<Chek> findAll() {
	return jdbcTemplate.query("select * from chek", rowMapper);
    }
}