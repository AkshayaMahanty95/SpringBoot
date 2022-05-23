package com.ojas.mailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ojas.mailsender.service.MailSenderService;

@SpringBootApplication
public class SpringMailSenderApplication {

	@Autowired
	private MailSenderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMailSenderApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		service.sendMail("akshayaMahanty2014@gmail.com", "This is Subject", "This is body");
	}

}
