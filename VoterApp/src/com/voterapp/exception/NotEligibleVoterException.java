package com.voterapp.exception;

public class NotEligibleVoterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEligibleVoterException() {
		
	}
	
	 public NotEligibleVoterException(String message){
		super(message);
		
	}

}
