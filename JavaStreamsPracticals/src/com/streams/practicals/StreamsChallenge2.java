package com.streams.practicals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsChallenge2 {
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers=Arrays.asList(10,15,20,25,30,35,40);

		List<Integer> listOfIntegerValues =listOfIntegers.stream()
				.filter(num->num%2==0)
				.map(num->num*num)
				.collect(Collectors.toList());
		listOfIntegerValues.forEach(value->System.out.println(value));
		
		listOfIntegers.stream()
				.filter(num->num%2==0)
				.map(num->num*num)
				.collect(Collectors.toList()).forEach(System.out::println);
	}

}
