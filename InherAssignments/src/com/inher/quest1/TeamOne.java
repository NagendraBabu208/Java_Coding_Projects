package com.inher.quest1;

public class TeamOne extends Project {

	@Override
	 public void doTask() {
		System.out.println("Project is implemented using Java");
		
	}
	
	public void softwaresUsed(String...tools) {
		
		for(String tool:tools) {
			System.out.println(tool);
		}
		
	}

}
