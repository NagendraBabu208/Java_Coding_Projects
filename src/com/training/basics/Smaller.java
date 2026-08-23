package com.training.basics;
// find smallest number in the Array
public class Smaller {
	
	public static void main(String[] args) {
		int[] array= {12, 45, 7, 89, 23, 56};
		
		int smallestNum=array[0];
		for(int i=1;i<array.length;i++) {
			
			if(array[i]<smallestNum) {
				smallestNum=array[i];
			}
		}
		System.out.println(" Smallest number in the Array:: "+smallestNum);
	}

}
