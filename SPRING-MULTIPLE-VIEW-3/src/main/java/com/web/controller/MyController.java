package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
    public String homePage() 
	{
		return "home" ;  // HERE IS A .JSP FILE 
	}
	
	@RequestMapping("/indexUrl")
	public String indexPage() 
	{
		return "index";   // HERE IS A .JSP FILE 
	}
	
	@RequestMapping("/loginUrl")
	public String loginPage() 
	{
		return "login";   // HERE IS A .JSP FILE 
	}
	
	@RequestMapping("/contactUrl")
	public String contactPage() 
	{
		return "contact";   // HERE IS A .JSP FILE 
	}
	
	@RequestMapping("/regUrl")
	public String registrationPage() 
	{
		return "reg";   // HERE IS A .JSP FILE 
	}
	
	
	
	
	
	

}
