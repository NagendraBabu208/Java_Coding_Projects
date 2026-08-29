package com.abs.quest1;

import java.util.Arrays;

public class AbsMain {
	
	public static void main(String[] args) {
		System.out.println("============================Branch1 Details=============================");
		Bank bank=new Branch1();
		bank.carLoan();
		bank.houseLoan();
		bank.educationLoan();
		bank.adviceDetails();
		
		Branch1 branch1=(Branch1) bank;
		System.out.println(" ====================Branch one own deposit types==============================");
		String[] depositTypes =branch1.depositeTypes();
		for(String depositType:depositTypes) {
			System.out.println("Deposit through -"+depositType);
			
	  }
		System.out.println("====================Branch2 Details===============================");
		 bank=new SubBranch();
		bank.carLoan();
		bank.houseLoan();
		bank.educationLoan();
		bank.adviceDetails();
	
		
		System.out.println("=============================SubBranch================================");
		Branch2 branch2= (Branch2) bank;
		String[] loanTypes=branch2.loanTypes();
		for(String loanType:loanTypes) {
			System.out.println(loanType);
		}
		
		SubBranch subBranch=(SubBranch) bank;
		String[]cardSchemes=subBranch.cardSchemes();
		System.out.println(Arrays.toString(cardSchemes));
	} 

}
