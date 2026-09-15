package com.bookapp.client;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class SortedClient2 {
	public static void main(String[] args) {
		
		IBookService bookService=new BookServiceImpl();
		List<Book> listBooks=bookService.getAllBooks();
		Comparator<Book> sortingBasedOnBookId =( o1,  o2)-> Integer.compare(o1.getBookId(), o2.getBookId());
		
		Collections.sort(listBooks,sortingBasedOnBookId);
		for(Book book:listBooks) {
			System.out.println(book);
		}
		System.out.println("=====================================================================");
		try {
			Book book=bookService.getById(1);
			System.out.println(book);
		} catch (BookNotFoundException  bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		System.out.println("======================================================================");
		try {
			List<Book> listOfBooks=bookService.getByAuthorAndCategory("Sudha", "Educational");
			Comparator<Book> sortingBasedAuthor=( o1,  o2)-> o1.getAuthor().compareTo(o2.getAuthor());

			Collections.sort(listOfBooks,sortingBasedAuthor);
			for(Book nbook:listOfBooks) {
				System.out.println(nbook);
				
			}
		} catch (BookNotFoundException bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		System.out.println("========================================================================================");
		try {
			List<Book> listOfBooksBasedOnPrice=bookService.getBylesserPrice(500);
			Comparator<Book> sortingBasedOnPrice =( o1,  o2)-> Double.compare(o1.getPrice(), o2.getPrice());

			
			Collections.sort(listBooks,sortingBasedOnPrice);
			for(Book book1:listOfBooksBasedOnPrice) {
				System.out.println(book1);
				
			}
		} catch (BookNotFoundException bookNotFoundException) {
		System.out.println(bookNotFoundException.getMessage());
		}
		
		
		try {
			List<Book> listOfBooksBasedTitle=bookService.getByTitleContains("Spring Boot");
			Comparator<Book> sortBasedTitle=(o1,o2)->o1.getTitle().compareTo(o2.getTitle());
			Collections.sort(listOfBooksBasedTitle, sortBasedTitle);
			
			for(Book book:listOfBooksBasedTitle) {
				System.out.println(book);
			}
		} catch (BookNotFoundException bookNotFoundException) {
			System.out.println(bookNotFoundException.getMessage());
		}
		
		
		
	}

}
