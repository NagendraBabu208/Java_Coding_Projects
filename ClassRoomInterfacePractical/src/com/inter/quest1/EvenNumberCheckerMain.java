package com.inter.quest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNumberCheckerMain {
	
	public static void main(String[] args) {
		
		IEvenNumberChecker evenNumberChecker=numbers->{
			List<Integer> evenNumbersList= new ArrayList<Integer>();
			
			for(int number:numbers) {
				if(number%2==0) {
					evenNumbersList.add(number);
				}
			}
		
			System.out.println("Even numbers List:: "+evenNumbersList);
			
		};
		evenNumberChecker.checkEvenNumbers(Arrays.asList(10,15,20,25,30,35,40));
		
		
	}

}
