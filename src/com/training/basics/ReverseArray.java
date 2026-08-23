package com.training.basics;

//print reverse array
public class ReverseArray {
	public static void main(String[] args) {
		int[] array= {12, 45, 7, 89, 23, 56};
		
		System.out.println("before reverse array ");
		for(int num:array) {
			System.out.print(num+" ");
		}
		System.out.println(" ");
		System.out.println("after reverse array ");
		for(int i=array.length-1;i>=0;i--) {
			System.out.print(array[i]+" ");
		}
	}

}
