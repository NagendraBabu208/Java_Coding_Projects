package com.voterapp.exception;

public class UnderAgeException extends NotEligibleVoterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnderAgeException() {
		
	}
	
	 public UnderAgeException(String message){
		super(message);
		
	}

}
