package com.voterapp.exception;

public class LocalilityNotFoundException extends NotEligibleVoterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LocalilityNotFoundException() {
		
	}
	
	 public LocalilityNotFoundException(String message){
		super(message);
		
	}

}
