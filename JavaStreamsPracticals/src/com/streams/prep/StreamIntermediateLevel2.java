package com.streams.prep;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamIntermediateLevel2 {
	
	public static void main(String[] args) {
		
		//	Q2)calculate the average age of a list of person objects using java 
		//Streams
		List<Person> listOfPersons=Arrays.asList(
				new Person("Nagendra", 25),
				new Person("Bob", 30),
				new Person("Charlie", 28),
				new Person("David", 35));
		
		
		Double averageAge=listOfPersons.stream()
				.collect(Collectors.averagingInt(Person::getAge));
		System.out.println(averageAge);
		
		//Q3)partition numbers in even and odd list
		List<Integer> listOfIntegers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Map<Boolean, List<Integer>> mapOfEvenOrOdd=listOfIntegers.stream()
		.collect(Collectors.partitioningBy(num->num%2==0));
		
		System.out.println("Even Numbers\n "+mapOfEvenOrOdd.get(true));
		System.out.println("Odd Numbers\n "+mapOfEvenOrOdd.get(false));
		
		//Q4) Group a list of words by their length using Streams 
		List<String> listOfWords=
				Arrays.asList("Apple","bike","cat","banana","box","room","box");
		
		Map<Integer, List<String>> map=listOfWords.stream()
		.collect(Collectors.groupingBy(str->str.length()));
		
		System.out.println(map);
		
		//Q5) count the occurrence of each element in a List
		
		Map<String, Long> map1=listOfWords.stream()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(map1);
		
	}

}
