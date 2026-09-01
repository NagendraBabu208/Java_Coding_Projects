package com.training.quest3;

import java.util.Scanner;

public class CompressorMain {
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		IFileCompressor fileCompressor=null;
		boolean isFileCompressor=true;
		while(isFileCompressor) {
			System.out.println("Enter user to select Zip/Rar/Jip file compressor.Please enter Exit if complete operation ");
			String userInput=scanner.nextLine();
			
			switch(userInput.toUpperCase()) {
			case"ZIP":
				System.out.println("Enter file names space seperated ");
				String userZipFileNames=scanner.nextLine();
				String[] zipArgsArray=userZipFileNames.split(" ");
				fileCompressor = new ZipCompressor();
				fileCompressor.compressFile(zipArgsArray);
				break;
			case "RAR":
				System.out.println("Enter file names space seperated");
				String userRarFileNames=scanner.nextLine();
				String[] rarArgsArray=userRarFileNames.split(" ");
				fileCompressor= new RarCompressor();
				fileCompressor.compressFile(rarArgsArray);
				break;
			case "JIP":
				System.out.println(" Enter file names space seperated");
				String userJipFileNames=scanner.nextLine();
				String[] jipArgsArray=userJipFileNames.split(" ");
				fileCompressor = new JIPComprosser();
				fileCompressor.compressFile(jipArgsArray);
				break;
			case "EXIT":
				System.out.println(" Thanks for using File Compressor ");
				return;
				default:
					System.out.println("Invalid User input!!!. Please enter valid input.");
					continue;
				}
			System.out.println();
		}
		
		if(scanner!=null) {
			scanner.close();
		}
		
	}

}
