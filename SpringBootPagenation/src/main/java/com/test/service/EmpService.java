package com.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.dao.EmpDao;
import com.test.domain.Employee;

@Service
public class EmpService {
	@Autowired
	public EmpDao empdao;
	
	public Employee createName(Employee empname) {
		return empdao.save(empname);
	}
	
	public Iterable<Employee> getAllEmployee(){
		return empdao.findAll();
	}
	
	public Optional<Employee> getEmployee(Integer empid){
		return empdao.findById(empid);
	}
	
	public void deleteEmp(Integer empid) {
		empdao.deleteById(empid);
	}
	
	public Iterable<Employee> pagenation(){
		return empdao.findAll(PageRequest.of(0,2));
		
	}
}
