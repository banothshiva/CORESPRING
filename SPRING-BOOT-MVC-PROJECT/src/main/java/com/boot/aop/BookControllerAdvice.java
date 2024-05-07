package com.boot.aop;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.boot.exception.DuplicateBookException;
import com.boot.model.Book;


@ControllerAdvice
public class BookControllerAdvice
{
	@ExceptionHandler(value = DuplicateBookException.class)
	public String duplicateBookExceptionHandling(DuplicateBookException bookException , ModelMap modelMap) 
	{
		Book book	= bookException.getBook();
		modelMap.addAttribute("book", book);
		modelMap.addAttribute("message","Ratan Sir Handled Exception Very Essily");
		return "error-page";
	}
}
