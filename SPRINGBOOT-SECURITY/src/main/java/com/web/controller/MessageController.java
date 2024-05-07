package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@GetMapping("/message")
	public String getMessage() 
	{
		return "WELCOME TO THE  STUDENT SECURITY";
	}
}
