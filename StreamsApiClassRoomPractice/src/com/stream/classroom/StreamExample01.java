package com.stream.classroom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample01 {
	
	public static void main(String[] args) {
		
		List<String> listOfStrings=
				Arrays.asList("Nagendra","Vasu","Raju","Manidhar","Ravi","Mahima","Raghav","Roji","mom");
		
		
		  List<String> namesList=listOfStrings.stream() .filter(str->str.contains("N"))
		  .collect(Collectors.toList());
		 
		
		System.out.println(namesList);
		System.out.println("===========================");
		
		listOfStrings.stream()
		.limit(5)
		.sorted()
		.forEach(name->System.out.println(name.toUpperCase()));
		
		System.out.println("============================");
		listOfStrings.stream()
		.map(str->str.toUpperCase())
		.forEach(System.out::println);
		System.out.println("==========================");
		listOfStrings.stream()
		.map(str->str.length())
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		System.out.println("=============================");
		listOfStrings.stream().
		filter(name->name.contains("o"))
		.sorted().collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("===================================");
		listOfStrings.stream()
		.sorted()
		.map(name->"Hello "+name)
		.collect(Collectors.toList())
		.forEach(System.out::println);
	}

}
