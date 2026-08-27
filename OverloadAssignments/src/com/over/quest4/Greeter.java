package com.over.quest4;

public class Greeter {
	
	private String name;

	
	public Greeter() {
		System.out.println("defalut constructor");
	}
	
	public Greeter(String name){
		this.name=name;
		
	}
	
	public void greetUser(String...messages) {
		
		for(String message:messages) {
			System.out.println(message+name);
		}
		
	}
	public void sayHello(String...names) {
		
		for(String name:names) {
			System.out.println(" Welcome "+name);
		}
		
	}

}
