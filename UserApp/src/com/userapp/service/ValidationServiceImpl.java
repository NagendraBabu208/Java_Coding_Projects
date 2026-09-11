package com.userapp.service;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidationServiceImpl implements IValidationService {

	@Override
	public boolean validatePassword(String password) throws TooShortException, TooLongException {
		
		boolean flag=true;
		
           if(password.length()<=6) {
				flag=false;
				throw new TooShortException("Password length is too short!!!.");
			
			}
			if(password.length()>=15) {
				flag=false;
				throw new TooLongException("Password length is too long!!!.");
				
			}
	   return flag;
	}

	@Override
	public boolean validateUserName(String userName) throws NameExistsException {
		
		String[] namesArray= {"Sri","Priya","Joe","Kathy"};
		boolean flag=false;
		
		
			for(String name:namesArray) {
				if(name.equals(userName)) {
					throw new NameExistsException("Name is already registered!!!.");
				}else {
					flag=true;
				}
		}
			return flag;

}
	}
