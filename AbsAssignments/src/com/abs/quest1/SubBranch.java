package com.abs.quest1;

public class SubBranch extends Branch2{

	@Override
	public void carLoan() {
		System.out.println("Car Loan provided by SubBranch:: ");

	}
  
	public String[] cardSchemes() {
		return new String[] {"Rupay","Visa","Master"};
		
	}

}
