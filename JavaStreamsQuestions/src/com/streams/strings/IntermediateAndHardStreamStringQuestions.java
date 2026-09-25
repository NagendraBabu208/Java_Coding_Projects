package com.streams.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateAndHardStreamStringQuestions {

	public static void main(String[] args) {
		List<String> names = Arrays.asList(
				"Naga","Suriya","Mamitha","Ravi","Priya","Naga",      // duplicate
				"Kiran","Priya", "Sneha","Rahul","Ravi","Arjun" );
		//8. Sort the list of strings based on their lengths 
		//in ascending/descending order.	

		List<String> namesSortedReverseBasedLeng=names.stream()
				.sorted(Comparator.comparingInt(String::length).reversed())
				.collect(Collectors.toList());
		System.out.println(namesSortedReverseBasedLeng);
		System.out.println("===========================================");

		//9. Find the longest word in the list.
		String maxLengthString=names.stream()
				.max(Comparator.comparingInt(String::length))
				.orElseThrow(()-> new NoSuchElementException("No Element fount with maximum length"));
		System.out.println(maxLengthString);
		System.out.println("=======================================");
		//10. Get the list of strings having vowels
		List<String> vowelStringNames=names.stream()
				.filter(name->name.toLowerCase().contains("a")||
						name.toLowerCase().contains("e")||
						name.toLowerCase().contains("i")||
						name.toLowerCase().contains("o")||
						name.toLowerCase().contains("u"))
				.collect(Collectors.toList());

		System.out.println(vowelStringNames);
		System.out.println("==========================================");
		//11. convert a list of strings into a single string, 
		//separated by commas, using streams


		String namesJoinedCommaSeperated=names.stream()
				.collect(Collectors.joining(", "));
		System.out.println(namesJoinedCommaSeperated);
		System.out.println("============================================");

		//12. Write a Java program to create a new list of strings, 
		//where each string is reversed from the original list, using Java streams.

		List<String> reverseNames=names.stream()
				.map(name->new StringBuilder(name).reverse().toString())
				.collect(Collectors.toList());
		System.out.println(reverseNames);
		System.out.println("=========================================");

		//13. Write a Java program to remove all strings from 
		//the list that are empty or null using streams.
		List<String> namesList=names.stream()
				.filter(name->!Objects.isNull(name) && !name.equals(""))
				.collect(Collectors.toList());
		System.out.println(namesList);
		System.out.println("======================================================");
		//14. Given a list of strings, group a list of strings by the first letter of 
		//each string using streams

		Map<Character, List<String>> map=names.stream()
				.collect(Collectors.groupingBy(name->name.charAt(0)));
		System.out.println(map);
		System.out.println("=====================================================");
		//15. Given a list of strings, group a list of strings
		//by the length of the string
		Map<Integer, List<String>> map1=names.stream()
				.collect(Collectors.groupingBy(name->name.length()));
		System.out.println(map1);
		System.out.println("=========================================================");
//16. Given a list of strings, create a map where the key 
//is the first letter of the string, 
//and the value is a list of strings 
//that start with that letter using streams
		
		Map<Character, List<String>> map2=names.stream()
		.collect(Collectors.groupingBy(name->name.charAt(0)));
		System.out.println(map2);
		
//19. Given a list of strings find the first element 
//having the length as 10 if not handle exceptions
		names.stream()
		.filter(name->name.length()==10)
		.findFirst()
		.orElseThrow(
				()-> new NoSuchElementException("Element not found with that length")
				);
		
	System.out.println("==============================================");	
//20. Reverse the list of strings using streams api
	/*
	 * List<String> reverseOrder=IntStream.range(0, names.size())
	 * .mapToObj(i->names.get(names.size()-1-i)) .collect(Collectors.toList());
	 * System.out.println(reverseOrder);
	 */
	 List<String> reverseList=names.stream()
	.sorted(Comparator.comparing(names::indexOf).reversed())
	.collect(Collectors.toList());
	 
	 System.out.println(reverseList);
		



	}}
