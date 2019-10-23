package com.turing.entity;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer id;

    private String name;

    private Integer deption;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDeption() {
        return deption;
    }

    public void setDeption(Integer deption) {
        this.deption = deption;
    }

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", deption=" + deption + "]";
	}
    
}