package com.techelevator.vendingprogram;

import java.io.File;

public class Program {

	public static void main(String[] args) {
		Menu menu = new Menu();
		String path = "/Users/mschroeder/repos/capstoneVending/capstone/vendingmachine.csv";
		File newFile = new File(path);
		VendingMachine vm = new VendingMachine(newFile);
		menu.titleCard();
		
		boolean finished = false;
		while (!finished) {
			
			menu.mainMenuGraphic();
			String selection = menu.getInputFromUser("Please select a menu: ");
			if (selection.equals("1")) {
				vm.printInventoryList();
			} else if (selection.equals("2")) {
				boolean done = false;
				while (!done) {
					menu.purchaseMenuGraphic();
					String purchaseSelection = menu.getInputFromUser("Please select an option: ");
					if(purchaseSelection.equals("1")) {
						menu.addFunds(vm);
					} else if(purchaseSelection.equals("2")) {
						menu.purchaseMenu(vm);
					} else if(purchaseSelection.equals("3")) {
						menu.finishTransaction(vm);
						done = true;
					}
				}
			} else if (selection.equals("3")) {
				System.out.println("Please come again!");
				finished = true;
				System.exit(1);
			} else {
				System.out.println("Invalid selection! Please make a new selection!");
			}
			
		}
	}

}
