package com.techguy.application.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(String to , String subject , String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("noreply@domain.lk");
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);
	}
	
	public void sendEmailAttachment(String to , String subject , String text , String path) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message , true);
			helper.setTo(to);
			helper.setFrom("noreply@domain.lk");
			helper.setSubject(subject);
			helper.setText(text);
			FileSystemResource file = new FileSystemResource(new File(path));
			helper.addAttachment("Invoice", file);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
