package com.training.basics;
// find greatest element in the array
public class Greater {
	
	public static void main(String[] args) {
		int[] array= {12, 45, 7, 89, 23, 56};
		
		int greatest=array[0];
		
		for(int i=1;i<array.length;i++) {
			
			if(array[i]>greatest) {
				greatest=array[i];
			}
		}
		System.out.println("greatest number in Array is:: "+greatest);
	}

}
