package com.streams.easyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample01 {
	
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//filter even numbers from list
		
	List<Integer> list=listOfIntegers.stream()
		.filter(num->num%2==0)
		.map(num->num*num)
		.collect(Collectors.toList());
	
	list.forEach(System.out::println);
	
	//convert numbers in list to their squares
	   listOfIntegers.stream()
	   .map(num->num*num)
	   .collect(Collectors.toList())
	   .forEach(System.out::println);
	   
	   //find the first number greater then 10 from list
		List<Integer> listOfIntegers1=Arrays.asList(3,7,12,5,11,20);
		
		int number=listOfIntegers1.stream()
		.filter(num->num>10)
		.sorted()
		.findFirst()
		.orElse(0);
		System.out.println(number);
		
		List<Integer> listOfIntegers2=Arrays.asList(2,6,3,8,10,1);
		
		long count=listOfIntegers2.stream()
		.filter(num->num>5).count();
		System.out.println(count);
		System.out.println("========================================");
		int sum=listOfIntegers2.stream()
		.mapToInt(Integer::intValue)
		.sum();
		System.out.println(sum);
		
		int sum1=listOfIntegers2.stream()
		.filter(num->num%2==0)
		.mapToInt(Integer::intValue)
		.sum();
		
		System.out.println(sum1);
		
		int maxNumber=listOfIntegers2.stream()
		.mapToInt(Integer::intValue).max().orElse(0);
		
		System.out.println(maxNumber);
		int sum2=listOfIntegers2.stream()
		.filter(num->num%2==0)
		.map(num->num*num)
		.mapToInt(Integer::intValue)
		.sum();
		
		System.out.println(sum2);


	   
	
	}

}
