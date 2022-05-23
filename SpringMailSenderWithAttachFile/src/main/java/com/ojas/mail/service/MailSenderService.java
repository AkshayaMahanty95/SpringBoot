package com.ojas.mail.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,
						  String body,
						  String subject) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("Spring.email.from@gmail.com");
		msg.setTo(toEmail);
		msg.setText(body);
		msg.setSubject(subject);
		
		mailSender.send(msg);
	}
	
	public void sendEmailWithAttatchment(String toEmail,
										 String body,
										 String subject,
										 String attachment) throws MessagingException {
		
		MimeMessage mime = mailSender.createMimeMessage();
		
		MimeMessageHelper healper = new MimeMessageHelper(mime,true);
		
		healper.setFrom("Spring.email.from@gmail.com");
		healper.setTo("akshayamahanty2014@gmail.com");
		healper.setText(body);
		healper.setSubject(subject);
		
		FileSystemResource resource = new FileSystemResource(new File(attachment));
		
		healper.addAttachment(resource.getFilename(), resource);
		
		mailSender.send(mime);
		System.out.println("file upload sucessfully");
		
		
	}

	
}
