package com.bookapp.execption;

public class BookNotFoundExecption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundExecption(String message) {
		super(message);
	}

}
