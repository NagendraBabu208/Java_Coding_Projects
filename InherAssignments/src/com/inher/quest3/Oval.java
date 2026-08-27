package com.inher.quest3;

public class Oval extends Figures {

	@Override
	public void volume(int semiAxes1, int semiAxes2, int semiAxes3) {
		
		double ovalVolume=(4/3)*Math.PI*semiAxes1*semiAxes2*semiAxes3;
		System.out.println("Oval Volume:: "+ovalVolume);
		

	}

	

	
}
