package com.inher.quest3;

public class Cube extends Figures {

	@Override
	public void volume(int length) {
		
		double cubeVolume=Math.pow(length, 3);
		System.out.println("Cube Volume:: "+cubeVolume);
		
	}

	

}
