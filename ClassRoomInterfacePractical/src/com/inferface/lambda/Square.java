package com.inferface.lambda;

public class Square implements IShape {

	@Override
	public void area(int a, int b) {
		System.out.println("calculating area "+(a*b));
		
	}

}
