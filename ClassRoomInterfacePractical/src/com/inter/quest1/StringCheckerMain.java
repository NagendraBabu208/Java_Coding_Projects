package com.inter.quest1;

import java.util.Arrays;

public class StringCheckerMain {
	
	public static void main(String[] args) {
		
		IStringChecker stringChecker=names->{
			
			for(String name:names) {
				
				if(name.startsWith("A")) {
					System.out.println(name);
				}
			}
			
		};
		stringChecker.checkNamesStartWithA(Arrays.asList("Arun","Balu","Anil","David","Ajay"));
	}

}
