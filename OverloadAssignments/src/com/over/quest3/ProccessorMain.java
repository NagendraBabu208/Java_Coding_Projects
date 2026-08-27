package com.over.quest3;

public class ProccessorMain {
	
	public static void main(String[] args) {
		Processor processor=new Processor();
		processor.calculate(10);
		processor.calculate(5);
		processor.calculate(10.0, 20.0);
		processor.calculate(10.0, 3.0 );
	}

}
