package com.training.basics;

public class SortArray {
	
	public static void main(String[] args) {
		int[] array= {12, 45, 7, 89, 23, 56};
		
		for(int i=0;i<array.length-1;i++) {
			
			if(array[i]>array[i+1]) {
				int temp=array[i];
				array[i]=array[i+1];
				array[i+1]=temp;
				
				i=-1;
			}
		}
		
		System.out.println("After sorting ascending order of the array:- ");
		for(int num:array) {
			System.out.print(num+" ");
		}
	}

}
