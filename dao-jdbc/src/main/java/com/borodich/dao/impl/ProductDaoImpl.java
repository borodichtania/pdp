package com.borodich.dao.impl;

import com.borodich.dao.api.ProductDao;
import com.borodich.entity.Product;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {

    public ProductDaoImpl() {
	super(Product.class);
    }
    
    class ProductRowMapper implements RowMapper<Product> {
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Product product = new Product();
	    product.setId(rs.getInt("id"));
	    product.setTitle(rs.getString("title"));
	    product.setPrice(rs.getDouble("price"));
	    product.setDescription(rs.getString("description"));
	    product.setExpiryDate(rs.getDate("expiry_date"));
	    return product;
	}
    }
    @Override
    public List<Product> getProductsFromSection(String titleSection) {

	return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List getAmountProductsForEachBrand() {
	return null;
    }

    @Override
    public Product findById(Integer id) {
	Product product = jdbcTemplate.queryForObject("select * from product where id=?", new Object[] { id }, new ProductRowMapper());
	System.out.println(jdbcTemplate);
	return product;
    }

    @Override
    public void saveAndFlush(Product entity) {
	// TODO Auto-generated method stub

    }

    @Override
    public void update(Product entity) {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(Product entity) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Product> findAll() {
	// TODO Auto-generated method stub
	return null;
    }
}