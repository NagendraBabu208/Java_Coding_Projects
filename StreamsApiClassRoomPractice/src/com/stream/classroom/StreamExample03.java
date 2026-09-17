package com.stream.classroom;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamExample03 {
	
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers=
				Arrays.asList(20,54,33,91,11);
		
		listOfIntegers.stream()
		.filter(num->num%2==0)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		int number=listOfIntegers.stream()
		.filter(num->num%2 !=0)
		.findFirst().orElseThrow(()->new NoSuchElementException("Element is not found!!!"));
		System.out.println(number);
		
		listOfIntegers.stream()
		.map(num->num*2)
		.forEach(System.out::println);
		System.out.println("==========================");
		listOfIntegers.stream()
		.map(num->num*2)
		.sorted()
		.forEach(System.out::println);
		System.out.println("===========================");
		listOfIntegers.stream()
		.map(num->num*2)
		.sorted()
		.limit(3)
		.forEach(System.out::println);
		
		
		
		
	}

}
