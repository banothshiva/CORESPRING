package com.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.exception.DuplicateBookException;
import com.boot.model.Book;

@Service
public class BookService {

	// static block are automatic executed when the class is loading 
   public  static ArrayList<Book> books = new ArrayList<>();
    
    static 
    {
        books.add(new Book(1001, "JAVA", "MR.SHIVA"));
        books.add(new Book(1002, "PYTHON", "MR.RATAN"));
        books.add(new Book(1003, ".NET", "MR.SWAMY"));
    }

   
    public boolean saveBookData(Book book) throws Exception 
    {
    Optional <Book>	exstingBook = books.stream()
					    	.filter(t -> t .getIsbn().equals(book.getIsbn()))
					    	.findFirst();
					    
    if (exstingBook.isPresent()) {
    	//throw new DuplicateBookException ("USER  RATAN sir data is already present check once ....... ");
		throw new DuplicateBookException (exstingBook);
    
    }
  
        return books.add(book);
    }
    // WHEN WE CLICK THE DELETE WE GOT THE NUMBER TO CONTROLLER GIVE TH NUMBER TO SERVICE LAYER based on the NUMBER GET THE BOOK & REMOVE THE BOOKS FROM THE EXISTING LIST & REDIRECT TO SAME PAGE HERE ONLY  

    public boolean deleteBookData( Integer isbn)  {
   Book  book = books.stream()
		   .filter(b -> b.getIsbn().equals(isbn)  )
		   .findFirst()
		   .get();
    		return books.remove(book);
    
    
    
    }
    //INVIEW LAYER WE CLICK ON HYPER LINK THE ISBN NUMBER SERVICE LAYER IS FINDING THE BOOK AND SEND TO THE CONTROLLER IT RETURN THE VIEW LAYER 
	public Book  editBook(Integer isbn) {
		Book book =	books.stream()
				.filter(t ->t.getIsbn().equals(isbn) )
				.findFirst()
				.get();
				return book;
	
	}

	public Book editBook(Book editbook) {
	Book book =	books.stream()
				.filter(t ->t.getIsbn().equals(editbook.getIsbn()) )
				.findFirst()
				.get();
	if ( book!= null) {
		book.setName(editbook.getName());
		book.setAuthor(editbook.getAuthor());
	}
	return book;
	}
	
	 public List<Book> getBooks() {
	        return books;
	    }

}

