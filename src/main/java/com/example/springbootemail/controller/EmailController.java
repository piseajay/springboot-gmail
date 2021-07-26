package com.example.springbootemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootemail.service.EmailService;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

	@Autowired
	EmailService emailService;

	@GetMapping("/sendEmail")
	public String sendEmail() {
		return emailService.sendEmail();
	}

	@GetMapping("/sendEmailwithAttachment")
	public String sendEmailwithAttachment() {
		return emailService.sendEmailwithAttachment();
	}

}