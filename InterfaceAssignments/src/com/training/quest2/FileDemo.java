package com.training.quest2;

import java.util.Scanner;

public class FileDemo {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		IExtractor extractor=null;
            boolean  isFileExtractionAvailable=true;
		while(isFileExtractionAvailable) {
			System.out.println("enter the input z->zip, j->jip and r-rar ");
			String userInput=scanner.nextLine();
			
		
			switch(userInput.toUpperCase()) {
			case "Z":
				System.out.println("enter the file Name:: ");
				String zipFileName=scanner.nextLine();
				extractor= new ZipExtractor();
				extractor.extractFiles(zipFileName);
				break;
			case "J":
				System.out.println("enter the file Name:: ");
				String jipFileName=scanner.nextLine();
				extractor=new JarExtractor();
				extractor.extractFiles(jipFileName);
				break;
			case "R":
				System.out.println("enter the file Name:: ");
				String rarFileName=scanner.nextLine();
				extractor=new RarExtractor();
				extractor.extractFiles(rarFileName);
				break;
			case "EXIT":
				System.out.println("Thanks for using Extraction of File. See you again");
				return;
			default:
				System.out.println("Invalid User Input Data. Please select proper data ");
				continue;
			}
			System.out.println();
			
			}
		
		if(scanner!=null) {
			scanner.close();
		}
		
	}

}
