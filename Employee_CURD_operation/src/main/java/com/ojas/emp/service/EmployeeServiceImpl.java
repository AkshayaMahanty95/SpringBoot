package com.ojas.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.emp.domain.Employee;
import com.ojas.emp.exception.EmployeeAlreadyExistsException;
import com.ojas.emp.exception.NoSuchEmployeeExistsException;
import com.ojas.emp.functionality.EmployeeService;
import com.ojas.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	// Add Employee
	// Method to add new Employee details to database.Throws
	// EmployeeAlreadyExistsException when Employee detail
	// already exist
	@Override
	public String addEmployee(Employee emp) {
		Employee existingEmp = repo.findById(emp.getEmpId()).orElse(null);
		if (existingEmp == null) {
			repo.save(emp);
			return "Employee added successfully";
		} else {
			throw new EmployeeAlreadyExistsException("Employee already exists..");
		}
	}

	// Get Employee
	// Method to get Employee by Id.Throws
	// NoSuchElementException for invalid Id
	@Override
	public Employee getEmp(int empId) {
		return repo.findById(empId)
				.orElseThrow(() -> new NoSuchEmployeeExistsException("No Employee present with id " + empId));
	}

	// update Employee
	// Method to update Employee details to database.Throws
	// NoSuchEmployeeExistsException when Employee doesn't
	// already exist in database
	@Override
	public String updateEmp(Employee emp) {
		Employee existingEmp = repo.findById(emp.getEmpId()).orElse(null);
		if (existingEmp == null) {
			throw new NoSuchEmployeeExistsException("No Such Employee Exists..!");
		} else {
			existingEmp.setEmpId(emp.getEmpId());
			existingEmp.setEmpName(emp.getEmpName());
			existingEmp.setClientName(emp.getClientName());
			existingEmp.setStartDate(emp.getStartDate());
			existingEmp.setEndDate(emp.getEndDate());
			repo.save(existingEmp);
			return "Record Update Successfully";
		}
	}

}
