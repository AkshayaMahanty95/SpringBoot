package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.Laptop;

public interface LaptopDao extends JpaRepository<Laptop, Integer> {

}
