package com.training.basics;

import java.util.HashMap;
import java.util.Map;

public class Duplicates {
	
	public static void main(String[] args) {
		int [] arr= {6,2,5,6,4,2,6,4};
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for(int key:arr) {
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			
			if(entry.getValue()>1) {
				System.out.println(" Duplicate key "+entry.getKey()+" count:- "+entry.getValue());
			}
		}
	}

}
