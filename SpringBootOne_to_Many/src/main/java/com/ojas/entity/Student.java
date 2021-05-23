package com.ojas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stud_O_M")
public class Student {
	
	@Id
	private int sno;
	private String sname;
	private int marks;
	
	@OneToMany(mappedBy = "stud")
	private Laptop laptop;
	
	
	
	

	public Student(int sno, String sname, int marks, Laptop laptop) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.marks = marks;
		this.laptop = laptop;
	}

	//setter and getter
	

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", marks=" + marks + ", laptop=" + laptop + "]";
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	

}
