package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

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
		
		for(Book nbook:books) {
			if(nbook.getBookId()==bookId) {
			return nbook;
				}
		}
		
		throw new BookNotFoundException("Book is not found with that bookId:: "+bookId);
	}

	@Override
	public List<Book> getBylesserPrice(double price) {
		
		List<Book> books=BookDetails.showBooks();
		
		List<Book> lowPriceBookList= new ArrayList<Book>();
		for(Book book:books) {
			if(book.getPrice()<price) {
				lowPriceBookList.add(book);
			}
		}
		
		if(lowPriceBookList.isEmpty()) {
			throw new BookNotFoundException("Books not found with that much lower price:: "+price);
		}
		
		return lowPriceBookList;
	}

	@Override
	public List<Book> getByTitleContains(String title) {
		List<Book> listBooks=BookDetails.showBooks();
		List<Book> booksByTitle=new ArrayList<Book>();
		
		for(Book book:listBooks) {
			if(book.getTitle().equals(title)) {
				booksByTitle.add(book);
				
			}
		}
		if(booksByTitle.isEmpty()) {
			throw new BookNotFoundException("Books Not found by title name:: "+title);
		}
		return booksByTitle;
	}

	@Override
	public List<Book> getByAuthorAndCategory(String author, String category) {
		List<Book> listBooks=BookDetails.showBooks();
		List<Book> booksByAuthorAndCategory= new ArrayList<Book>();
		
		for(Book book:listBooks) {
			if(book.getAuthor().equals(author)&& book.getCategory().equals(category)) {
				booksByAuthorAndCategory.add(book);
			}
		}
		if(booksByAuthorAndCategory.isEmpty()) {
			throw new BookNotFoundException("Books Not found by Author and category :: ");
		}
		
		return booksByAuthorAndCategory;
	}

}
