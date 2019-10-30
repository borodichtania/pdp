package com.borodich.entity;

import com.borodich.entity.api.AbstractBaseEntity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress extends AbstractBaseEntity {
    private static final long serialVersionUID = 9035380868408172439L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "apartment")
    private String apartment;

    @OneToMany(mappedBy = "adress")
    private List<Chek> cheks;

    public Adress() {
    }
    
    public Adress(String cityNew, String streetNew, String houseNew, String apartmentNew) {
	this.city = cityNew;
	this.street = streetNew;
	this.house = houseNew;
	this.apartment = apartmentNew;
    }

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public String getHouse() {
	return house;
    }

    public void setHouse(String house) {
	this.house = house;
    }

    public String getApartment() {
	return apartment;
    }

    public void setApartment(String apartment) {
	this.apartment = apartment;
    }

    public List<Chek> getCheks() {
	return cheks;
    }

    public void setCheks(List<Chek> cheks) {
	this.cheks = cheks;
    }
}