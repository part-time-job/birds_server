package com.ue.domain;

import java.io.Serializable;

/**
 * Created by bage on 2016/3/13.
 */
public class User3 implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id; // 用户id
    private String name;
    private String sex;
	public User3() {
		super();
	}
	public User3(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	public User3(int id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User3 other = (User3) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}

    
    
}
