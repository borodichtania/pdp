package com.borodich.dao.impl;

import com.borodich.dao.api.ProductDao;
import com.borodich.entity.Product;
import com.borodich.entity.Product_;
import com.borodich.entity.Section;
import com.borodich.entity.Section_;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

@Repository
public class ProductDaoImpl extends AbstractBaseDao<Product> implements ProductDao {

    public ProductDaoImpl() {
	super(Product.class);
    }

    @Override
    public List<Product> getProductsFromSection(String titleSection) {
	CriteriaQuery<Product> query = getCriteriaQuery();
	Root<Product> productRoot = query.from(Product.class);
	productRoot.fetch(Product_.section);
	productRoot.fetch(Product_.brand);
	
	Subquery<Integer> subquery = query.subquery(Integer.class);
	Root<Section> sections = subquery.from(Section.class);
	Join<Section, Product> subquerySection = sections.join(Section_.products);

	subquery.select(subquerySection.get(Product_.id))
		.where(getCriteriaBuilder().and(getCriteriaBuilder().equal(sections.get(Section_.title), titleSection)));
	query.where(getCriteriaBuilder().in(productRoot.get(Product_.id)).value(subquery));
	List<Product> products = getTypedQuery(query).getResultList();
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List getAmountProductsForEachBrand() {
	CriteriaQuery query = entityManager.getCriteriaBuilder().createQuery();
	Root<Product> productRoot = query.from(Product.class);
	query.multiselect(getCriteriaBuilder().count(productRoot.get(Product_.id)), productRoot.get(Product_.brand));
	query.groupBy(productRoot.get(Product_.brand));
	List products = getTypedQuery(query).getResultList();
	return products;
    }
}