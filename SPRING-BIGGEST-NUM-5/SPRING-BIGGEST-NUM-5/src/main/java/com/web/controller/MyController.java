package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController 
{
	@RequestMapping("/")
	public String numberForm() 
	{
		return "number";
	}
	
	@RequestMapping("/biggest")
	public String checkBiggestNumber(@RequestParam int firstNumber,
									@RequestParam int secondNumber,
									@RequestParam int thirdNumber,
									ModelMap modelMap
			
			
			) 
	{
		modelMap.put("key1", firstNumber);
		modelMap.put("key2", secondNumber);
		modelMap.put("key3", thirdNumber);
		int  maxNumber;
		if (firstNumber>secondNumber &&firstNumber>thirdNumber) 
		{
			maxNumber=firstNumber;
		}
		else if (secondNumber > firstNumber &&  secondNumber > thirdNumber) {
			maxNumber=secondNumber;

		}
		else {
			maxNumber=thirdNumber;
		}
		
		modelMap.put("maxNumber", maxNumber);
		return "result";
	}

}
