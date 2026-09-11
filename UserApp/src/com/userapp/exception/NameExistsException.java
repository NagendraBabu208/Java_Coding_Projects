package com.userapp.exception;

public class NameExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NameExistsException() {
		// TODO Auto-generated constructor stub
	}
	
	public NameExistsException(String message) {
		super(message);
	
	}

}
