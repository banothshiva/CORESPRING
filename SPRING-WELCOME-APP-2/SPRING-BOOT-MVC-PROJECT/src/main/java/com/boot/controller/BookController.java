
package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.model.Book;
import com.boot.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	BookService bookService;
	
	
	// service layer  returns  the data to controller ----> controller layer  add the data into model object -----> model object data we are populating in JSP file 
	@GetMapping("/viewBooks")
	public String getAllBooksDetails(ModelMap modelMap) 
	{
		//READ THE BOOKS SEND THE BOOKS TO VIEW LAYER USING MODEL OBJECT 
		// to  call the getBook Method used BookService 
		List <Book> books = bookService.getBooks();
		modelMap.addAttribute("books", books);
		return "view-books";   //.JSP FILE 
	}
	
	//repository layer return the data to  service layer  returns  the data to controller ----> controller layer  add the data into model object -----> model object data we are populating in JSP file 
	// when click the book slash add book it went request  to the hyperlink add book JSP
	@GetMapping("/addBook")
	public String addNewBookPage() 
	{
		return "add-book";
	}
	
	//URL GOING TO THE CONTROLLER MAPPING TO THE BOOK OBJECT SERVICE LAYER   AND NEW BOOK DATA IS SAVE IN saveBook 
	// BindingResult it is used   store  errors 
	@PostMapping("/savebook")
	public String saveBook(@Valid @ModelAttribute Book book, BindingResult bindingResult, ModelMap modelMap, RedirectAttributes redirectAttributes) throws Exception 
	{
	    if (bindingResult.hasErrors())
	    {
	        // Add the BindingResult to the model attributes with the key "errors"
	        modelMap.addAttribute("errors", bindingResult);
	        // Return the addBook view to display the form with validation errors
	        return "add-book";
	    }

	     boolean status = bookService.saveBookData(book);
	    if (status) {
	        // Save account ...
	    	//  redirectAttributes.addFlashAttribute("saveSuccessMessage", "Data saved successfully");
	        redirectAttributes.addFlashAttribute("saveSuccessMessage",true);

	    }
	    return "redirect:/books/viewBooks";
	}
	
	// HIPER LINKS ARE ALWAYS INDICATES THE GETMAPPING REQUEST ONLY
	@GetMapping("/delete/{isbn}")
	public String deleteBookRecord(@PathVariable Integer isbn, RedirectAttributes redirectAttributes) 
	{
		// to call the service layer data 
		boolean status =bookService.deleteBookData(isbn);
		if (status) 
		{
			redirectAttributes.addFlashAttribute("deleteMessage",true);
		}
		return "redirect:/books/viewBooks";		
	}
	
	
	@GetMapping("/edit/{isbn}")
	public String editBook(@PathVariable Integer isbn , ModelMap modelMap) 
	{
		Book book = bookService.editBook(isbn);
		modelMap.addAttribute("book", book);
		return "edit-form";
		
	}
	
	@PostMapping("/editsavebook")
	public String saveEditBook(@ModelAttribute Book editbook , RedirectAttributes redirectAttributes) 
	{
		Book book = bookService.editBook(editbook);
		if (book != null)
		{
			redirectAttributes.addFlashAttribute("editmessage",true);
		}

		return "redirect:/books/viewBooks";		

	}
	
}

