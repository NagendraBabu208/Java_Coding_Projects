package com.voterapp.voter;

import com.voterapp.exception.LocalilityNotFoundException;
import com.voterapp.exception.NotEligibleVoterException;
import com.voterapp.exception.UnderAgeException;
import com.voterapp.exception.VoterIdNotFoundException;
import com.voterapp.service.ElectionBootImpl;
import com.voterapp.service.IElectionBoot;

public class Voter {
	
	public static void main(String[] args) {
		
		IElectionBoot electionBoot= new ElectionBootImpl();
		boolean value=false;
		
		try {
			 value =electionBoot.checkEligibility(20, "JP Nagar", 199);
			
		} catch (UnderAgeException |	LocalilityNotFoundException |VoterIdNotFoundException ex) {
		
			System.out.println(ex.getMessage());
		}catch (NotEligibleVoterException ex) {
			System.out.println(ex.getMessage());
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(value) {
			System.out.println("Your eligible to cast your Vote!!!!.");
		}
	}

}
