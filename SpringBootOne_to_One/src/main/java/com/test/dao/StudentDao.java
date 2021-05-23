package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
