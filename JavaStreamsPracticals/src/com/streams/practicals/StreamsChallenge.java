package com.streams.practicals;

import java.util.Arrays;
import java.util.List;

public class StreamsChallenge {
	
	public static void main(String[] args) {
		
		List<String> listOfStrings=
			Arrays.asList("Nagendra","Ravi","Anil","Nagendra","kiran","Ravi","Suresh","Abhi");
		
		listOfStrings.stream()
		.filter(name->name.length()>5)
		.distinct()
		.sorted()
		.forEach(System.out::println);
	}

}
