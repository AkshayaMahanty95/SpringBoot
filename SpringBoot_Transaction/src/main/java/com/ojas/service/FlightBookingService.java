package com.ojas.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.PassengerInfoDao;
import com.ojas.dao.PaymentInfoDao;
import com.ojas.entity.PassengerInfo;
import com.ojas.entity.PaymentInfo;
import com.ojas.reqres.FlightBookingAcknowledgement;
import com.ojas.reqres.FlightBookingRequest;
import com.ojas.util.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoDao passengerInfodao;
	
	@Autowired
	private PaymentInfoDao paymentdao;
	
	@Transactional //(readOnly = false,isolation.READ_COMITTED,propagation.REQUIRED)
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfodao.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getpId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentdao.save(paymentInfo);
		return new FlightBookingAcknowledgement("Sucess",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
		
	}
}
