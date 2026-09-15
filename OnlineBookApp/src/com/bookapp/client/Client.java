package com.bookapp.client;

import java.util.Collections;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {
	public static void main(String[] args) {
		
		IBookService bookService=new BookServiceImpl();
		List<Book> listBooks=bookService.getAllBooks();
		
		for(Book book:listBooks) {
			System.out.println(book);
		}
		System.out.println("==============================================================");
		
		try {
			Book book=bookService.getById(1);
			System.out.println(book);
		} catch (BookNotFoundException  bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		System.out.println("==================================================================");
		try {
			List<Book> listOfBooks=bookService.getByAuthorAndCategory("Sudha", "Educational");
			
			for(Book nbook:listOfBooks) {
				System.out.println(nbook);
				
			}
		} catch (BookNotFoundException bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		System.out.println("=======================================================================");
		try {
			List<Book> listOfBooksBasedOnPrice=bookService.getBylesserPrice(500);
			
			for(Book book1:listOfBooksBasedOnPrice) {
				System.out.println(book1);
				
			}
		} catch (BookNotFoundException bookNotFoundException) {
		System.out.println(bookNotFoundException.getMessage());
		}
		System.out.println("=====================================================================");
		
		try {
			List<Book> listOfBooksByTitle=bookService.getByTitleContains("Spring Boot");
			for(Book book:listOfBooksByTitle) {
				System.out.println(book);
			}
		} catch (BookNotFoundException bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
			
		}
		
		
		
	}

}
