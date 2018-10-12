package com.techelevator.vendingprogram;

import java.io.File;

public class Program {

	public static void main(String[] args) {
		Menu menu = new Menu();
		String path = "/users/ntillman/repos/other/team6-java-week4-pair-exercises/capstone/vendingmachine.csv";
		File newFile = new File(path);
		VendingMachine vm = new VendingMachine(newFile);
		
		menu.titleCard();
		menu.mainMenu();
		
		String selection = menu.getInputFromUser("Please make a selection: ");
		if(selection.equals("1")) {
			vm.getList();
		} else if(selection.equals("2")) {
			menu.purchaseMenu();
		} else {
			System.out.println("Invalid selection! Please make a new selection!");
		}
	}
	
	
}
