package com.stream.classroom;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamExample02 {
	
	public static void main(String[] args) {
		
		List<String> courses=
				Arrays.asList("Java","Css","Html","Angular","Spring","Microservices");
		
		
		String course=courses.stream()
		.sorted().findFirst()
		.orElseThrow(()->new NoSuchElementException("Name is not found"));
		System.out.println(course);
	}

}
