package com.streams.strings;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class BasicStringStreamQuestions {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Bangalore","Hyderabad","Chennai", "Delhi",
				"Mumbai","Kolkata","Chennai","Pune","Goa","Mysore","Lucknow","Pune","Nagpur","Jaipur" );

		//1. Convert a list of strings to uppercase , sort them and print
		cities.stream()
		.sorted()
		.map(name->name.toUpperCase())
		.forEach(System.out::println);
		System.out.println("==================================================");
		// 2. Get the list of strings where the length of each element is >5 and get the count
		List<String> namesLengGreaterThan5=cities.stream().filter(name->name.length()>5)
				.collect(Collectors.toList());
        long count= namesLengGreaterThan5.stream().count();
        System.out.println(namesLengGreaterThan5);
        System.out.println(count);
        System.out.println("======================================");
	
       //3) Remove duplicates from a list
        List<String> uniqueNamesList= cities.stream()
        .distinct()
        .collect(Collectors.toList());
        System.out.println(uniqueNamesList);
        System.out.println("==================================================");
        //4. Get the list of strings having a particular word 
       List<String> namesContainsSpecificLetter=cities.stream().filter(name->name.contains("n"))
       .collect(Collectors.toList());
       
       System.out.println(namesContainsSpecificLetter);
       System.out.println("=========================================");
       
	//5. Write a Java program to remove strings that start with
       //a specific word from a list using streams.
       List<String> removeNamesStartsWithC=cities.stream().filter(name->!name.startsWith("C"))
       .collect(Collectors.toList());
       System.out.println(removeNamesStartsWithC);
       
       System.out.println("==================================================");
       //6. Find the first element in a list that starts with a particular letter
      String firstName= cities.stream()
    	 .filter(name->name.startsWith("C"))
       .findFirst()
       .orElseThrow(()-> new NoSuchElementException("No Name starts with C"));
      System.out.println(firstName);
      System.out.println("=================================================");
     //7. Get the length of each name in a list 
      List<Integer> namesLengList=cities.stream()
      .map(String::length)
      .collect(Collectors.toList());
      
      System.out.println(namesLengList);

       
       

	
	}

}
