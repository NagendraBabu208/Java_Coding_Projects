package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {
	
	void addBook(Book book);
	boolean deleteBookById(int bookId);
	Book getBookById(int bookId);
	boolean updateBook(int bookId,double bookPrice);
	List<Book> getAllBooks();
	List<Book> getBooksByAuthor(String author);
	List<Book> getBooksByPublisher(String publisher);

}
