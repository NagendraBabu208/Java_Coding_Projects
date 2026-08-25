package com.basics.quest1;

public class BookMain {
	
	public static void main(String[] args) {
		
		Book book1= new Book("Core Java", "Vidya", 400, "Technical");
		Book book2= new Book("Spring", "Nagendra", 800, "Technical");
		
		//calling methods on book1
		book1.getBookDetails();
		book1.checkBookType();
		System.out.println("=============================================");
		//calling methods on book2
		book2.getBookDetails();
		book2.checkBookType();
	}

}
