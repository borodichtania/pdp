package com.borodich.entity;

import com.borodich.entity.api.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
@NamedEntityGraph(
	  name = "product-entity-graph",
	  attributeNodes = {
	    @NamedAttributeNode("section"),
	    @NamedAttributeNode("brand")
	  }
	)
public class Product extends AbstractBaseEntity {
    private static final long serialVersionUID = -1962662067708450327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiry_Date")
    private Date expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_fk")
    @JsonIgnore
    private Section section;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_fk")
    @JsonIgnore
    private Brand brand;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Chek> cheks;

    public Product() {
    }
    
    public Product(String titleNew, Double priceNew, Date expiryDateNew) {
	this.title = titleNew;
	this.price = priceNew;
	this.expiryDate = expiryDateNew;
    }

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Date getExpiryDate() {
	return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
    }

    public Section getSection() {
	return section;
    }

    public void setSection(Section section) {
	this.section = section;
    }

    public Brand getBrand() {
	return brand;
    }

    public void setBrand(Brand brand) {
	this.brand = brand;
    }

    public List<Chek> getCheks() {
	return cheks;
    }

    public void setCheks(List<Chek> cheks) {
	this.cheks = cheks;
    }
}