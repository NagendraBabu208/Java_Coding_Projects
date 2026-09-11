package com.voterapp.service;

import com.voterapp.exception.NotEligibleVoterException;

public interface IElectionBoot {
	
	boolean checkEligibility(int age, String locality,long voterId) throws NotEligibleVoterException;

}
