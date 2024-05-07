package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public String homepage() 
	{
		return "home";	 // HERE IS A .JSP FILE 
	}
	
	@RequestMapping("/contact")
	public String contactPage() 
	{
		return "contact";		 // HERE IS A .JSP FILE 
	}

	@RequestMapping("/login")
	public String loginPage() 
	{
		return "login";		 // HERE IS A .JSP FILE 
	}

	@RequestMapping("/about")
	public String aboutPage() 
	{
		return "about";			 // HERE IS A .JSP FILE 
	}

	@RequestMapping("/reg")
	public String registerPage() 
	{
		return "reg";			 // HERE IS A .JSP FILE 
	}

}
