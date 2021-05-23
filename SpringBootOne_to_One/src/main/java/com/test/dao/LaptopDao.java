package com.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.domain.Laptop;
@Repository
public interface LaptopDao extends JpaRepository<Laptop, Integer> {

}
