package com.voterapp.service;

import com.voterapp.exception.LocalilityNotFoundException;
import com.voterapp.exception.NotEligibleVoterException;
import com.voterapp.exception.UnderAgeException;
import com.voterapp.exception.VoterIdNotFoundException;

public class ElectionBootImpl implements IElectionBoot {

	@Override
	public boolean checkEligibility(int age, String locality, long voterId) throws NotEligibleVoterException  {

		if(checkAgeEligibility(age) && checkLocality(locality) && checkVoterId(voterId) ) {
			return true;
		}
		
		return false;
	}


	private boolean checkAgeEligibility(int age) throws UnderAgeException {


		if(age<18) {
			throw new UnderAgeException("Your not eligible to cast to vote");
		}

		return true;

	}

	private boolean checkLocality(String locality)throws LocalilityNotFoundException{

		String[] voterLocalities= {"JP Nagar","Jaya Nagar","Banashankari","Whitefield"};

		for(String voterlocality:voterLocalities) {

			if(voterlocality.equals(locality)) {
				return true;

			}
		}

		throw new LocalilityNotFoundException("Your Locality not found in this Election Boot!!!");

	}

	private boolean checkVoterId(long voterId) throws VoterIdNotFoundException{

		if(voterId<=10000 && voterId>=1000) {
			throw new VoterIdNotFoundException("Your Voter id not found!!!");
		}

		return true;
	}
}
