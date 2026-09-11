package com.inter.quest1;

public class NumberCheckerMain {
	
	public static void main(String[] args) {
		
		INumberChecker numberChecker=number->{
			if(number%2==0) {
				return true;
			}
			return false;
		};
		
		System.out.println(numberChecker.check(6));
	}

}
