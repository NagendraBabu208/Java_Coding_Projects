package com.oops.basics;

public class Greater {
	
	
	public void printMessage(String...names) {
		
		for(String name:names) {
			System.out.println("Great Day, "+name.toUpperCase()+"!!!");
		}
		
	}
	public void printMessages(String name,String...stringNames) {
		
		for(String message:stringNames) {
			System.out.println(message+name);
		}
	}
	
	public static void main(String[] args) {
		Greater greater=new Greater();
		greater.printMessage("Priya","Ravi");
		System.out.println("==============================================================");
		greater.printMessages("priya", "Hello ","Welcome ", "Bye Bye ");
	}

}
