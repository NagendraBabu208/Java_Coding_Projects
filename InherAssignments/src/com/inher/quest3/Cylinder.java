package com.inher.quest3;

public class Cylinder extends Figures {

	@Override
	public void volume(int radious, int height) {
		double volume=Math.PI*((Math.pow(radious, 2))*height);
		System.out.println("Cylinder Volume ="+volume);
	
	}
	
	

}
