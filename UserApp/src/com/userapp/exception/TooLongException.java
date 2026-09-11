package com.userapp.exception;

public class TooLongException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TooLongException() {
		
	}
	
	public TooLongException(String message) {
		super(message);
	
	}

}
