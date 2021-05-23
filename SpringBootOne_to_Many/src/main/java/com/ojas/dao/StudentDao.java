package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
