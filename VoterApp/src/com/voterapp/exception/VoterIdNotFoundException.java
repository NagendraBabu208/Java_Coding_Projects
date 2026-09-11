package com.voterapp.exception;

public class VoterIdNotFoundException extends NotEligibleVoterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VoterIdNotFoundException() {
		
	}
	
	 public VoterIdNotFoundException(String message){
		super(message);
		
	}

}
