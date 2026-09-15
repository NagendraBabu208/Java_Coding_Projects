package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {
	
	List<Book> getAllBooks();
	Book getById(int bookId);
	List<Book> getBylesserPrice(double price);
	List<Book> getByTitleContains(String title);
	List<Book> getByAuthorAndCategory(String author,String category);

}
