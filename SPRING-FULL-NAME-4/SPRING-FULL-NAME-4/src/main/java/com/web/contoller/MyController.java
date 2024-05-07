package com.web.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public String  nameForm() 
	{
		return "name";    //JSP FILE NAME HERE 
	}

	@RequestMapping("/request")
	public String fullName(@RequestParam String firstName,
			@RequestParam String lastName , ModelMap  model) 
	{
		model.put("key1",firstName );
		model.put("key2", lastName);
		String fullName = firstName + lastName;
		model.putIfAbsent("fullName", fullName);
		return "result";  // JSP  file name for display FULLNAME   
		
	}
}
