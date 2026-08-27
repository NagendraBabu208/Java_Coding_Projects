package com.over.quest4;

public class GreeterMain {
	public static void main(String[] args) {
		Greeter greeter=new Greeter("Nagendra");
		greeter.greetUser("Welcome ", "Great Day ");
		greeter.greetUser("Good Day ","Have Tea","Enjoy Learning");
		
		Greeter greeter2= new Greeter();
		greeter2.sayHello("Sri","priya","Nagendra");
	}

}
