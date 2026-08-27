package com.inher.quest1;

public class CompanyMain {
	public static void main(String[] args) {
		
		Project project=new TeamOne();
		project.doTask();
		
		TeamOne teamOne=(TeamOne) project;
		teamOne.softwaresUsed("eclipse","Jenkins","maven");
		
		System.out.println("=====================================================");
		Project project2=new TeamTwo();
		project2.doTask();
		
		TeamTwo teamTwo=(TeamTwo) project2;
		
		String[] techStack=teamTwo.getTechStack();
		
		for(String course:techStack) {
			System.out.println(course);
		}
	}

}
