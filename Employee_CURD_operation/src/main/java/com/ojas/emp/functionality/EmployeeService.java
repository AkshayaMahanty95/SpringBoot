package com.ojas.emp.functionality;

import com.ojas.emp.domain.Employee;

public interface EmployeeService {

	// Method to add a new Employee into the database
	String addEmployee(Employee emp);

	// Method to get Employee by its empId
	Employee getEmp(int empId);
	
	//Method to update details of Employee
	String updateEmp(Employee emp);
}
