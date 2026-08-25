package com.training.basics;

public class ReversingNumber {
	
	public static void main(String[] args) {
		int number=1234;
		String num=String.valueOf(number);
		String[] strArray=num.split("");
		String reverseStringNum="";
		for(int i=strArray.length-1;i>=0;i--) {
		
			reverseStringNum=reverseStringNum+strArray[i];
		}
		
		int reverseNum=Integer.parseInt(reverseStringNum);
		System.out.println(" reverse number ::"+reverseNum);
	}

}
