package com.ojas.csv_file.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "status")
	private boolean status;

}
