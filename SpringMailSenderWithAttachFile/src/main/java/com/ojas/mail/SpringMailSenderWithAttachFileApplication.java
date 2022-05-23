package com.ojas.mail;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ojas.mail.service.MailSenderService;

@SpringBootApplication
public class SpringMailSenderWithAttachFileApplication {

	@Autowired
	private MailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringMailSenderWithAttachFileApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)

	public void triggerMail() throws MessagingException {

		service.sendEmailWithAttatchment("Spring.email.from@gmail.com", "This is email body",
											"This email has attachment file",
											"C:\\Users\\am21101\\Desktop\\tm.png");
	}
}
