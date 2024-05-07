package com.boot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Book {
    @NotNull(message = "ISBN cannot be null")
    private Integer isbn;

    @NotBlank(message = "Book Name Is Required")
    private String name;

    @Size(min = 3, max = 25, message = "Book Author Name should be between 3 to 25 Characters")
    @NotBlank(message = "Author Name Is Required")
    private String author;

    // constructors, getters, and setters

//PDC
	public Book()
	{
		super();
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book(@NotNull(message = " ISBN can not Null") Integer isbn,
			@NotBlank(message = "Book Name Is Required ") String name,
			@Size(min = 5, max = 25, message = " Book Author Name between 3 to 25 Characters ") @NotBlank(message = "Author Name Is Required") String author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", author=" + author + "]";
	}	
}