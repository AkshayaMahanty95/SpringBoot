package com.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {

	@Id
	private int lid;
	private String name;
	@OneToOne(mappedBy = "laptop")
	private Student student;
	
	public Laptop() {
		super();
	}
	public Laptop(int lid, String name) {
		super();
		this.lid = lid;
		this.name = name;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + "]";
	}
	
	
	
	
	
}
