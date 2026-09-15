package com.streams.practicals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintEvenNumbers {
	
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers=Arrays.asList(10,15,20,25,30,35,40);
	//	List<Integer> evenNumbersList=listOfIntegers.stream().filter(num->num%2==0).toList();
		List<Integer> evenNumbersList=	listOfIntegers.stream().filter(num->num%2==0).collect(Collectors.toList());
		System.out.println(evenNumbersList);
	}

}
