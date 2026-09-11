package com.userapp.exception;

public class TooShortException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TooShortException() {
		
	}
	
	public TooShortException(String message) {
		super(message);
	
	}

}
