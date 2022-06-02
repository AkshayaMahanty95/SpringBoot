package com.ojas.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.emp.domain.Employee;
import com.ojas.emp.service.EmployeeServiceImpl;

@RestController
public class EmployeeDetailsController {

	@Autowired
	private EmployeeServiceImpl service;

	// New employee adding in database
	@PostMapping("/newemp")
	public String newEmp(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}

	// Get Employee by empId
	@GetMapping("/emp/{empId}")
	public Employee getById(@PathVariable("empId") int empId) {
		return service.getEmp(empId);
	}

	// Update record
	@PutMapping("/update_emp")
	public String updateEmp(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}
	
	//Delete record
	@DeleteMapping("/delete_emp/{empId}")
	public String deleteEmp(@PathVariable ("empId") int empId) {
		return service.deleteEmp(empId);
		
	}
}
