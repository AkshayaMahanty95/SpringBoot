package com.ojas.csv_file.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.csv_file.dao.EmployeeRepository;
import com.ojas.csv_file.entity.Employee;
import com.ojas.csv_file.utility.CSVHelper;

@Service
public class EmpCSVService {
  @Autowired
  EmployeeRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Employee> emp = CSVHelper.csvToEmp(file.getInputStream());
      repository.saveAll(emp);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<Employee> emp = repository.findAll();

    ByteArrayInputStream in = CSVHelper.empToCSV(emp);
    return in;
  }

  public List<Employee> getAllTutorials() {
    return repository.findAll();
  }
}

