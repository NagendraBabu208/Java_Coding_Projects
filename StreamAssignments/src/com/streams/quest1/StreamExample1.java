package com.streams.quest1;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {
	
	public static void main(String[] args) {
	
	//1)print the sum of numbers using aggregate method sum and IntStream class	
		List<Integer> listOfIntegers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int sumValue=listOfIntegers.stream()
		.mapToInt(Integer::intValue)
		.sum();
		
		System.out.println(sumValue);
		
		//2)print even numbers from 1 to 100 using range filter method
	     IntStream.rangeClosed(1, 100)	
	     .filter(num->num%2==0)
	     .forEach(System.out::println);
	     
	     //3)create a list of names and remove duplicates, and get the names starting with S
	     List<String> listOfStrings=Arrays.asList("Nagendra","Sai","Manidhar","Samba","Nagendra");
	     
	     List<String> listofNamesWithS=listOfStrings.stream()
	     .distinct()
	     .filter(str->str.startsWith("S"))
	     .collect(Collectors.toList());
	     
	     System.out.println(listofNamesWithS);
	     
	     //4)create a list of names , and print only the length of each name
	     listOfStrings.stream()
	     .map(str->str.length())
	     .forEach(System.out::println);
	     
	     //5) create a list of names, and print the sum of length of all names
	   int wordsLengthSum= listOfStrings.stream()
	     .map(str->str.length())
	     .collect(Collectors.toList())
	     .stream()
	     .mapToInt(Integer::intValue)
	     .sum();
	   System.out.println("Sum = "+wordsLengthSum);
	   
	   //6)Create a list of names, sort, remove duplicates and print only the first name 
	  String firstName= listOfStrings.stream()
	   .distinct().sorted()
	   .findFirst()
	   .orElseThrow(()->new NoSuchElementException("No Element is found!!!."));
	   
	   System.out.println("First Name:: "+firstName);
	    
	   //7)Create an array of numbers as string, convert to integer and then get the sum 
	   String[] numbersArray= {"1","2","3","4","5","6","7","8","9","10"};
	   
	  int sum1= Arrays.stream(numbersArray)
	   .map(number->Integer.parseInt(number))
	   .mapToInt(Integer::intValue)
	   .sum();
	  
	  System.out.println("Sum = "+sum1);
	  
	  //8)Print a list of numbers with generate method(Math.random), limit the count to 5 
	  System.out.println("======================================");
	  Stream.generate(Math::random)
	  .limit(5).forEach(System.out::println);
	  
	  System.out.println("=========================================");
	  //9)Create a two dimensional array with numbers and get the sum of all numbers 

	  int[][] numbers = {
	            {1, 2, 3},
	            {4, 5, 6},
	            {7, 8, 9}
	        };
	  
	  int sum12=Arrays.stream(numbers)
			  .flatMapToInt(Arrays::stream)
			  .sum();
	  System.out.println(sum12); 
	  
	}

}
