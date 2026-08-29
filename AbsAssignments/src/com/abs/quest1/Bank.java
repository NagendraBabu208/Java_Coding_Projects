package com.abs.quest1;

public abstract class Bank {
	
	abstract void carLoan();
	abstract void houseLoan();
	abstract void educationLoan();
	
	void adviceDetails() {
		System.out.println(" will provide advice details which loan you want:: ");
	}

}
