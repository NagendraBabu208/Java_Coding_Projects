package com.streams.quest2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MobileMain {
	
	public static void main(String[] args) {
		
		List<Mobile> listOfMobiles=Arrays.asList(
				new Mobile("3G", "Samsung", 6000, 101),
				new Mobile("5G", "Nokia", 10000, 102),
				new Mobile("6G", "Redmi", 25000, 10),
				new Mobile("4G", "Samsung", 6000, 104),
				new Mobile("3G", "Nokia", 6000, 105));
		
		//Get the list of mobiles by a brand using filter method and
		List<Mobile> mobileListBasedOnBrand=listOfMobiles.stream()
		.filter(mobile->mobile.getBrand().equals("Samsung"))
		.collect(Collectors.toList());
		System.out.println(mobileListBasedOnBrand);
		System.out.println("=======================================");
		//c.Get one list of mobiles by brand, sort by model and print them
		listOfMobiles.stream().
		filter(mobile->mobile.getBrand().equals("Samsung"))
		.sorted(Comparator.comparing(Mobile::getModel))
		.forEach(System.out::println);
		System.out.println("===================================================");
		//d.Get one mobile by id 10 if not found throw runtime exception 

		Mobile getMobileById=listOfMobiles.stream()
		.filter(mobile->mobile.getMobileId()==10)
		.map(Function.identity()).
		findFirst().
		orElseThrow(()-> new NoSuchElementException(" Element is not found!!!. "));
		System.out.println(getMobileById);
		//Get list of mobiles by brand and price less than 20000 
		
		List<Mobile> listofMobilesBasedByBrand =listOfMobiles.stream()
		.filter(mobile->mobile.getBrand()=="Samsung" && mobile.getPrice()<20000)
		.collect(Collectors.toList());
		System.out.println("===========================================");
		System.out.println(listofMobilesBasedByBrand);
		
		//f.Get the list of mobiles by brand, sort by model and print only the mobile names 
		System.out.println("===========================================");
		listOfMobiles.stream()
		.filter(mobile->mobile.getBrand()=="Samsung")
		.sorted(Comparator.comparing(Mobile::getModel))
		.collect(Collectors.toList())
		.forEach(mobile->System.out.println("Mobile name :: "+mobile.getBrand()));
		
		
		

	}
	

}
