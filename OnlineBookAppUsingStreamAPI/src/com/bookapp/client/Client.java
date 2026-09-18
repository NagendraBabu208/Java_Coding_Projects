package com.bookapp.client;

import java.util.Comparator;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {
	public static void main(String[] args) {
		
		IBookService bookService=new BookServiceImpl();
		List<Book> listBooks=bookService.getAllBooks();
		
		listBooks.stream()
		.sorted(Comparator.comparing(Book::getBookId))
		.forEach(System.out::println);
		
		System.out.println("===============================================================");
		
		try {
			Book book=bookService.getById(1);
			System.out.println(book);
		} catch (BookNotFoundException  bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		
		System.out.println("======================================================================");
		try {
			List<Book> listOfBooks=bookService.getByAuthorAndCategory("Sudha", "Educational");
			
			listOfBooks.stream()
			.sorted(Comparator.comparing(Book::getAuthor))
			.forEach(System.out::println);
			
		} catch (BookNotFoundException bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		
		System.out.println("========================================================================================");
		try {
			List<Book> listOfBooksBasedOnPrice=bookService.getBylesserPrice(500);
			
			listOfBooksBasedOnPrice.stream()
			.sorted(Comparator.comparing(Book::getPrice))
			.forEach(System.out::println);
		
		} catch (BookNotFoundException bookNotFoundException) {
		System.out.println(bookNotFoundException.getMessage());
		}
		
		
		try {
			List<Book> listOfBooksBasedTitle=bookService.getByTitleContains("Spring Boot");
			
			listOfBooksBasedTitle.stream()
			.sorted(Comparator.comparing(Book::getTitle))
			.forEach(System.out::println);
			
		} catch (BookNotFoundException bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		
		
		
		
		
	}

}
