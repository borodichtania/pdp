package com.borodich.entity.api;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {

    private static final String ID = " id = ";
    private static final long serialVersionUID = 2819451432191359131L;

    public abstract Integer getId();

    public abstract void setId(Integer id);

    @Override
    public boolean equals(Object object) {
	if (this == object) {
	    return true;
	}
	if (object == null || !(object instanceof AbstractBaseEntity)) {
	    return false;
	}
	if (!object.getClass().equals(this.getClass())) {
	    return false;
	}

	Integer id = getId();
	AbstractBaseEntity that = (AbstractBaseEntity) object;
	if (id == null) {
	    return false;
	}
	if (id != null ? !id.equals(that.getId()) : that.getId() != null) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	Integer id = getId();
	return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder(getClass().getName());
	sb.append(ID).append(getId());
	return sb.toString();
    }
}