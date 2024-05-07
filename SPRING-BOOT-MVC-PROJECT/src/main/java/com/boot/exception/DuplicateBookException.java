package com.boot.exception;

import java.util.Optional;

import com.boot.model.Book;

public class DuplicateBookException extends Exception{

	//Instance variables
	Book book;
	public DuplicateBookException( String msg) {
		super(msg);
	}

	public DuplicateBookException(Optional<Book> exstingBook) {
		book = exstingBook.get();
	}
	public Book getBook() {
		return book;
	}


	
}
