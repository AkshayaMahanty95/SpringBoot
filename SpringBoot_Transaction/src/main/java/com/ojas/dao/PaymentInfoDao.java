package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.PaymentInfo;

public interface PaymentInfoDao extends JpaRepository<PaymentInfo, String> {

}
