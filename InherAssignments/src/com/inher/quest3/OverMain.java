package com.inher.quest3;

import java.util.Scanner;

public class OverMain {
	
	public static void main(String[] args) {
		Figures figure=null;
		Scanner scanner= new Scanner(System.in);
		boolean isFiguresAvailable=true;
		
		while(isFiguresAvailable) {
			System.out.println("enter the which object[cube/cuboid/oval/cylinder/exit] you want find volume of that::");
			String objectType=scanner.nextLine();
			if("CUBE".equalsIgnoreCase(objectType.toUpperCase())) {
				System.out.println(" enter the length of the Cube:: ");
				int cubeLength=scanner.nextInt();
				figure= new Cube();
				figure.volume(cubeLength);
				scanner.nextLine();
			}else if("CUBOID".equalsIgnoreCase(objectType.toUpperCase())) {
				System.out.println(" enter the length of the Cuboid:: ");
				int cuboidLength=scanner.nextInt();
				System.out.println("enter the breadth of the Cuboid:: ");
				int cuboidBreadth=scanner.nextInt();
				System.out.println(" enter the height of the Cuboid:: ");
				int cuboidHeight=scanner.nextInt();
				figure=new Cuboid();
				figure.volume(cuboidLength, cuboidBreadth, cuboidHeight);
				scanner.nextLine();
				}else if("OVAL".equalsIgnoreCase(objectType.toUpperCase())) {
					System.out.println(" enter the length of the Oval:: ");
					int semiAxesOval1=scanner.nextInt();
					System.out.println("enter the breadth of the Oval:: ");
					int semiAxesOval2=scanner.nextInt();
					System.out.println(" enter the height of the Oval:: ");
					int semiAxesOval3=scanner.nextInt();
					figure=new Oval();
					figure.volume(semiAxesOval1, semiAxesOval2, semiAxesOval3);
					scanner.nextLine();
				}else if("CYLINDER".equalsIgnoreCase(objectType.toUpperCase())) {
					System.out.println(" enter the length of the Cylinder:: ");
					int radiousOfCylinder=scanner.nextInt();
					System.out.println("enter the breadth of the Cylinder:: ");
					int heightOfCylinder=scanner.nextInt();	
					figure= new Cylinder();
					figure.volume(radiousOfCylinder, heightOfCylinder);
					scanner.nextLine();
					}
				else if("EXIT".equalsIgnoreCase(objectType.toUpperCase())){
					System.out.println("Thanks for using Objects!! ");
					return;
				}
				else {
					System.out.println("please select right Object::");
					continue;// it will continue to start again to asking user to select appropriate object
				}
			
		}
		if(scanner!=null) {
			scanner.close();
		}
	    
	}

}
