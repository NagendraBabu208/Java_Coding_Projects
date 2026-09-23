package com.methodreference;

public class MathMain {

	public static void main(String[] args) {
		ISports sports=new Games()::show;
		sports.printGames();
	}
}
