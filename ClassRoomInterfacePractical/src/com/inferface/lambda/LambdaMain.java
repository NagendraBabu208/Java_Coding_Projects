package com.inferface.lambda;

public class LambdaMain {
	
	public static void main(String[] args) {
		
		IShape shape=(x,y)->System.out.println(x*y);
		shape.area(10, 10);
		
		
		IShape shape2=(x,y)->System.out.println("Rectange "+(x*y));
		shape.area(20, 20);
		
		
		IMessager messager=message->"Welcome"+message;
		System.out.println(messager.showMessage("Nagendra"));
		
		ICuisine cuisine=((menu)->{
			for(String name:menu) {
				System.out.println(name);
			}
		}
		);
		cuisine.printMenu(new String[] {"Indian","Italian"});
	}
	

}
