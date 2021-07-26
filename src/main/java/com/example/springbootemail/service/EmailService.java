package com.example.springbootemail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendEmail() {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom("piseajayspringboot@gmail.com");
		mailMessage.setTo("piseajay5@gmail.com");
		mailMessage.setSubject("Spring boot test email");
		mailMessage.setText("Hi Pise Ajay, This is a test email sent from Ajay's Spring boot App.");

		mailSender.send(mailMessage);

		return "Mail Sent successfully!!!!";
	}

	public String sendEmailwithAttachment() {
	
		String [] toList = {"dattatraymasal213@gmail.com","ganeshtakale21@gmail.com"};
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		try {
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
			
			messageHelper.setFrom("piseajayspringboot@gmail.com");
			messageHelper.setCc("piseajay5@gmail.com");
			messageHelper.setTo(toList);
			messageHelper.setSubject("Spring boot test email");
			messageHelper.setText("Hi Guys, This email is sent from Ajay Pise's Spring boot app. Please <html><a href=https://in.linkedin.com/in/piseajay>click here</a></html>, if you want to see his Linkedin profile."
					+ " And don't forget to reply, once you receive the mail.",true);
			
			
			//sent attachment
			//File file = new File("file path");
			//messageHelper.addAttachment(file.getName(), file);
			
			mailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			return "Mail sending failed!!!";
		}
		return "Mail Sent successfully!!!!";
	}

}
