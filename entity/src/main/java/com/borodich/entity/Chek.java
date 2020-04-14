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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "chek")
public class Chek extends AbstractBaseEntity {
    private static final long serialVersionUID = 102515391124451968L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private String number;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    private Date dateStart;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_finish")
    private Date dateFinish;
    
    @Column(name = "sum")
    private Double sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_fk")
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_fk")
    @JsonIgnore
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_fk")
    @JsonIgnore
    private Adress adress;

    @ManyToMany()
    @JoinTable(name = "chek_has_product", joinColumns = { @JoinColumn(name = "chek_fk") }, inverseJoinColumns = { @JoinColumn(name = "product_fk") })
    @JsonIgnore
    private List<Product> products;

    public Chek() {
    }
    
    public Chek(String numberNew, Boolean isPaidNew, Date dateStartNew, Double sumNew, Customer customerNew, List<Product> productsNew, Vendor vendorNew, Adress adressNew) {
	this.number = numberNew;
	this.isPaid = isPaidNew;
	this.dateStart = dateStartNew;
	this.sum = sumNew;
	this.customer = customerNew;
	this.products = productsNew;
	this.vendor = vendorNew;
	this.adress = adressNew;
    }
    
    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Boolean isPaid() {
	return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
	this.isPaid = isPaid;
    }

    public Date getDateStart() {
	return dateStart;
    }

    public void setDateStart(Date dateStart) {
	this.dateStart = dateStart;
    }

    public Date getDateFinish() {
	return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
	this.dateFinish = dateFinish;
    }
    
    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public Vendor getVendor() {
	return vendor;
    }

    public void setVendor(Vendor vendor) {
	this.vendor = vendor;
    }

    public Adress getAdress() {
	return adress;
    }

    public void setAdress(Adress adress) {
	this.adress = adress;
    }

    public List<Product> getProducts() {
	return products;
    }

    public void setProducts(List<Product> products) {
	this.products = products;
    }
}