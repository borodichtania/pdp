package com.borodich.entity;

import com.borodich.entity.api.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
public class Vendor extends AbstractBaseEntity {
    private static final long serialVersionUID = 2243220376669935489L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private Boolean status;// 0 - free

    @Column(name = "name")
    private String name;
    
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "vendor")
    @JsonIgnore
    private List<Chek> cheks;

    public Vendor() {
    }
    
    public Vendor(String nameNew) {
	this.name = nameNew;
    }
    
    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Boolean getStatus() {
	return status;
    }

    public void setStatus(Boolean satus) {
	this.status = satus;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Chek> getCheks() {
	return cheks;
    }

    public void setCheks(List<Chek> cheks) {
	this.cheks = cheks;
    }
}