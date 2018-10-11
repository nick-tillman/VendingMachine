package com.techelevator.vendingprogram;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);

		String path = "/users/ntillman/repos/other/team6-java-week4-pair-exercises/capstone/vendingmachine.csv";
		File newFile = new File(path);
		VendingMachine vm = new VendingMachine(newFile);
		boolean done = false;
		while (!done) {
			log("What would you like to purchase?");
			String userSelection = inputReader.nextLine();
			vm.purchaseItem(userSelection);
		}

	}

	public static void log(String message) {
		System.out.println(message);
	}

	// users/ntillman/repos/other/team6-java-week4-pair-exercises/capstone/vendingmachine.csv

}
