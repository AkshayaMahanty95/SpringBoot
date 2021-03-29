package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.domain.Employee;
@Repository
public interface EmpDao extends JpaRepository<Employee, Integer> {

}
