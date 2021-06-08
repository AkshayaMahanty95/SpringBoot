package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.PassengerInfo;

public interface PassengerInfoDao extends JpaRepository<PassengerInfo, Long> {

}
