package com.inter.quest1;

public class StringProcessorMain {
	
	public static void main(String[] args) {
		
		IStringProcessor stringProcessor=str->str.toUpperCase();
		System.out.println(stringProcessor.process("nagendra"));
		
		
		stringProcessor=str->str.toLowerCase();
		System.out.println(stringProcessor.process("NAGENDRA"));
		
		stringProcessor=str->{
			String reverseString="";
			for(int index=str.length()-1;index>=0;index--) {
				reverseString=reverseString+str.charAt(index);
			}
				
			return reverseString;
		};
		
		System.out.println("Reverse String :: "+stringProcessor.process("Nagendra babu"));
	}

}
