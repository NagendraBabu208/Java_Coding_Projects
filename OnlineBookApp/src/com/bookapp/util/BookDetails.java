package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import com.bookapp.model.Book;

public class BookDetails {
	
	public static List<Book> showBooks(){
		List<Book> listOfBooks=
				Arrays.asList(
						new Book(1, "Core Java", "Sudha", 250, "Educational"),
						new Book(2, "Spring", "Sudha", 500, "Educational"),
						new Book(3, "LoveStory", "Ravindrar", 350, "Story"),
						new Book(4, "Power of SubConcious Mind", "Joseph Murphy", 400, "Story"),
						new Book(5, "Spring Boot", "Sudha", 1000, "Educational"),
						new Book(6, "Micro Services", "Nagendra", 2000, "Educational"));
		
		return listOfBooks;
		
	}

}
