package com.streams.practicals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsChallenge3 {
	
	public static void main(String[] args) {
		List<Integer> listOfIntegers=Arrays.asList(15,40,10,25,40,30,15,50,20,30,60);
		
		listOfIntegers.stream().distinct().
		sorted(Comparator.reverseOrder())
		.limit(3).
		forEach(System.out::println);
		
		List<Integer> listOfIntegers1=Arrays.asList(10,25,30,45,50,65,70,85,90);
		System.out.println("============================================");
		long count=listOfIntegers1.stream()
		.filter(num->num>50).count();
		System.out.println(count);
		
		List<Integer> listOfIntegers2=Arrays.asList(15,25,35,42,55,60,75);
   Integer number= listOfIntegers2.stream()
    .filter(num->num>40)
    .findFirst()
    .orElseThrow(()->new NoSuchElementException("Number is not found"));
System.out.println(number);

List<Integer> listOfIntegers3=Arrays.asList(10,20,35,45,60,75);

boolean value=listOfIntegers3.stream()
                  .anyMatch(num->num>70);
System.out.println(value);



	}

}
