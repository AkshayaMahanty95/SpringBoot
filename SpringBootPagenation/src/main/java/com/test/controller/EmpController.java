package com.test.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.Employee;
import com.test.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
    private EmpService service;
  
    @GetMapping("/getallemp")
    public Iterable<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }
    // creating Student
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee emp) {
        return service.createName(emp);
    }
    // Get at Student
        @GetMapping("/emp/{empid}")
        public Optional<Employee>displayEmp(@PathVariable Integer empid) {
            return service.getEmployee(empid);
        }

        @DeleteMapping("/emp/{empid}")
        public void deleteEmployee(@PathVariable("empid") Integer empid) {
            service.deleteEmp(empid);
        }
        
        @GetMapping("/empPage") 
        public Iterable<Employee> getEmployees(){
            return service.pagenation();
        }
        
   
}
