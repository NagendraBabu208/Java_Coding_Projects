package com.inher.quest1;

public class TeamTwo extends Project {

	@Override
	public void doTask() {
		System.out.println("Project is implemented using Python");

	}

	public String[] getTechStack() {
		return new String[] {"Java", "Spring","Angular"};

	}

}
