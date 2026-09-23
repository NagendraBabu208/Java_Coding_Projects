package com.bookapp.client;


import java.util.List;

import com.bookapp.execption.BookNotFoundExecption;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookClient {
	
	public static void main(String[] args) {
		
		IBookService bookService= new BookServiceImpl();
		bookService.addBook(new Book(6, "JSP", "Sulochana", "Falcon Publishers", 500));
		System.out.println("============================================================");
		
		try {
		bookService.deleteBookById(7);
		
		}catch (BookNotFoundExecption bookNotFoundExecption) {
			System.out.println(bookNotFoundExecption.getMessage());
		}
		
		System.out.println("==================================================");
		try {
		List<Book> listOfBooks=bookService.getAllBooks();
		
		listOfBooks
		.stream()
		.forEach(System.out::println);
		
		}catch (BookNotFoundExecption  bookNotFoundExecption) {
			System.out.println(bookNotFoundExecption.getMessage());
		}
		System.out.println("==================================================");

		
		try {
		List<Book> listOfBooks=bookService.getBooksByAuthor("Radha");
		
		listOfBooks
		.stream()
		.forEach(System.out::println);
		
		}catch (BookNotFoundExecption bookNotFoundExecption) {
			System.out.println(bookNotFoundExecption.getMessage());
		}
		System.out.println("==================================================");

		try {
			List<Book> listOfBooks=bookService.getBooksByPublisher("Falcon Publishers");
			
			listOfBooks
			.stream()
			.forEach(System.out::println);
			
			}catch (BookNotFoundExecption bookNotFoundExecption) {
				System.out.println(bookNotFoundExecption.getMessage());
			}
		System.out.println("==================================================");

		try {
		Book book=bookService.getBookById(2);
		System.out.println(book);
		}catch(BookNotFoundExecption bookNotFoundExecption) {
			System.out.println(bookNotFoundExecption.getMessage());
		}
		System.out.println("==================================================");

		try {
		bookService.updateBook(1, 1500);
		}catch (BookNotFoundExecption bookNotFoundExecption) {
			System.out.println(bookNotFoundExecption.getMessage());
			
		}
	}

}
