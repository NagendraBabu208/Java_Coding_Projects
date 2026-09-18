package com.bookapp.service;


import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAllBooks() {

		return BookDetails.showBooks();
	}

	@Override
	public Book getById(int bookId) {
		List<Book> books=BookDetails.showBooks();

		Book nbook=books.stream()
				.filter(book->book.getBookId()==bookId)
				.findAny()
				.orElseThrow(
						()->new BookNotFoundException("Book is not found with bookId :: "+bookId));

		return nbook;
	}

	@Override
	public List<Book> getBylesserPrice(double price) {

		List<Book> books=BookDetails.showBooks();

		List<Book> lowPriceBookList=books.stream()
				.filter(book->book.getPrice()<price)
				.collect(Collectors.toList());

		if(lowPriceBookList.isEmpty()) {
			throw new BookNotFoundException("Books not found with that much lower price:: "+price);
		}

		return lowPriceBookList;
	}

	@Override
	public List<Book> getByTitleContains(String title) {
		List<Book> listBooks=BookDetails.showBooks();


		List<Book> booksByTitle =listBooks.stream()
				.filter(book->book.getTitle().equals(title))
				.collect(Collectors.toList());


		if(booksByTitle.isEmpty()) {
			throw new BookNotFoundException("Books Not found by title name:: "+title);
		}
		return booksByTitle;
	}

	@Override
	public List<Book> getByAuthorAndCategory(String author, String category) {
		List<Book> listBooks=BookDetails.showBooks();
		
		List<Book> booksByAuthorAndCategory=listBooks.stream()
		.filter(book->book.getAuthor().equals(author) && book.getCategory().equals(category))
		.collect(Collectors.toList());

	
		if(booksByAuthorAndCategory.isEmpty()) {
			throw new BookNotFoundException("Books Not found by Author and category :: ");
		}

		return booksByAuthorAndCategory;
	}

}
