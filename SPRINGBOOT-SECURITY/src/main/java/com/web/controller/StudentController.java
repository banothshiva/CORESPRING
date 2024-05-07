package com.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping("/student")
	public String getStudent() 
	{
		return "WELCOME TO THE STUDENT  SECURITY";
	}
}
