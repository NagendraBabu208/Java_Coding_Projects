package com.streams.easy2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class JavaStreamCodingInterviewQuestions {

	public static void main(String[] args) {
		//find all distinct elements from a list
		List<Integer> listOfIntegers=
				Arrays.asList(12,8,12,4,3,12,15);
		
		List<Integer> listOfNumbers=listOfIntegers.stream()
		.distinct().sorted()
		.collect(Collectors.toList());
		
		System.out.println(listOfNumbers);
		
		//find the average of all numbers in a list
		Double value=listOfIntegers.stream()
		.mapToInt(Integer ::intValue)
		.average()
		.orElse(0.0);
		
		System.out.println(value);
		
		//sort a list of integers in ascending and descending order using streams

		listOfIntegers.stream()
		.sorted()
		.forEach(System.out::println);
		System.out.println("==================================================");
		listOfIntegers.stream()
		.sorted(Comparator.comparingInt(Integer::intValue)
				.reversed()).forEach(System.out::println);
		
		//count how many strings start with a specific letter like ("A ")
		List<String> listStrings=Arrays.asList("Nagendra","Amrutha","Amulya","Ravi");
		
		long count=listStrings.stream()
		.filter(str->str.startsWith("A"))
		.count();
		System.out.println("==========================");
		System.out.println(count);
		//join all Strings in a list into a comma -separated string
	    String name=listStrings.stream()
		.collect(Collectors.joining(", "));
	    System.out.println(name);
	    
	    //check if all elements are positive numbers
	    List<Integer> listOfIntegers1=
				Arrays.asList(12,8,12,4,3,12,10);
	    //check all numbers in the list are positive numbers are not 
	  boolean value1= listOfIntegers1.stream().allMatch(number->number>0);
	    System.out.println(value1);
	    
	    //check if any number is divisible by 3
	   List<Integer> divisibleBy3= listOfIntegers1.stream().distinct()
		.sorted(Comparator.comparingInt(Integer::intValue))
	    .filter(num->num%3==0).collect(Collectors.toList());
	   System.out.println(divisibleBy3);
	   
	   //find first non empty String in a list
		List<String> listStrings1=Arrays.asList("","","Amulya","Ravi");
 
	   String name2=listStrings1.stream()
	   .filter(str->!str.isEmpty())
	   .findFirst()
	   .orElseThrow(()->new NoSuchElementException("No element found!!!"));
	   
	    System.out.println(name2);
	    
	    //find the second highest number in a list using streams
	    
		Integer intNumber=listOfIntegers.stream()
		.sorted(Comparator.comparingInt(Integer::intValue).reversed())
		.skip(1).findFirst()
		.orElseThrow(()->new NoSuchElementException("Number is not found!!"));
		System.out.println(intNumber);
		
	}
}
