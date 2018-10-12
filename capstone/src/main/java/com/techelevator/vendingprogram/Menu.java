package com.techelevator.vendingprogram;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
	
	public static String getInputFromUser(String message) {
		Scanner inputReader = new Scanner(System.in);
		System.out.println(message);
		String userInput = inputReader.nextLine();
		return userInput;
	}
	
	public void addFunds(VendingMachine vm) {
		System.out.println();
		double money;
		String moneyString = getInputFromUser("Please enter how much money you would like to add: $");
		if(moneyString.equals("1")) {
			money = Double.parseDouble(moneyString);
			vm.addFunds(money);
			System.out.print("Added $1.00. Your current balance is $" + vm.getCustomerFunds());
		} else if(moneyString.equals("2")) {
			money = Double.parseDouble(moneyString);
			vm.addFunds(money);
			System.out.print("Added $2.00. Your current balance is $" + vm.getCustomerFunds());
		} else if(moneyString.equals("5")) {
			money = Double.parseDouble(moneyString);
			vm.addFunds(money);
			System.out.print("Added $5.00. Your current balance is $" + vm.getCustomerFunds());
		} else if(moneyString.equals("10")) {
			money = Double.parseDouble(moneyString);
			vm.addFunds(money);
			System.out.print("Added $10.00. Your current balance is $" + vm.getCustomerFunds());
		} else {
			System.out.println("We only accept denominations of $1, $2, $5 and $10!");
		}
		
	}
	
	public void finishTransaction(VendingMachine vm) {
		if(vm.getCustomerFunds() > 0) {
			System.out.println("Please take your change: $" + vm.giveChange());
		}
		System.out.println("Enjoy your snacks!");
		Queue<Item> copyQueue = new LinkedList<Item>();
		copyQueue = vm.getCustomerPurchases();
		
		for(int i = 0; i <= copyQueue.size(); i++) {
			String sound = copyQueue.remove().getSound();
			System.out.println(sound);
		}
	}
	
	public void purchaseMenu(VendingMachine vm) {
		System.out.println("You have $" + vm.getCustomerFunds() + " left to spend.");
		vm.printInventoryList();
		String temp = getInputFromUser("Please enter a slot number: ");
		String userSelection = temp.toUpperCase();
		if(!vm.isValidSlot(userSelection)) {
			System.out.println("Please enter a valid slot number!");
		} else if(vm.getCustomerFunds() < vm.getPurchasePrice(userSelection)) {
			System.out.println("You do not have enough funds! Please add money!");
		} else if(vm.getPurchaseItemQty(userSelection) < 0) {
			System.out.println("SOLD OUT! Please make a different selection!");
		} else {
			vm.purchaseItem(userSelection);
			System.out.println("Enjoy your " + vm.getPurchaseItemName(userSelection) + "!");
		}
	}
	
	public void mainMenuGraphic() {
		System.out.println();
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println();
		System.out.println("1 >>> Display Vending Machine Items");
		System.out.println("2 >>> Purchase");
		System.out.println("3 >>> Quit");
		System.out.println();

	}
	
	public void purchaseMenuGraphic() {
		System.out.println();
		System.out.println();
		System.out.println("PURCHASE MENU");
		System.out.println();
		System.out.println("1 >>> Feed Money");
		System.out.println("2 >>> Select Product");
		System.out.println("3 >>> Finish Transaction");

		System.out.println();
	}
	
	public void titleCard() {
		System.out.println("                                                                                        ");
		System.out.println(" #     # ####### #     # ######  ### #     #  #####                                     ");
		System.out.println(" #     # #       ##    # #     #  #  ##    # #     #                                    ");
		System.out.println(" #     # #       # #   # #     #  #  # #   # #                                          ");
		System.out.println(" #     # #####   #  #  # #     #  #  #  #  # #  ####                                    ");
		System.out.println("  #   #  #       #   # # #     #  #  #   # # #     #                                    ");
		System.out.println("   # #   #       #    ## #     #  #  #    ## #     #                                    ");
		System.out.println("    #    ####### #     # ######  ### #     #  #####                                     ");
		System.out.println("                                                                                        ");
		System.out.println(" #     #    #     #####  #     # ### #     # #######     #####    ###     ###     ###   ");
		System.out.println(" ##   ##   # #   #     # #     #  #  ##    # #          #     #  #   #   #   #   #   #  ");
		System.out.println(" # # # #  #   #  #       #     #  #  # #   # #          #     # #     # #     # #     # ");
		System.out.println(" #  #  # #     # #       #######  #  #  #  # #####       ###### #     # #     # #     # ");
		System.out.println(" #     # ####### #       #     #  #  #   # # #                # #     # #     # #     # ");
		System.out.println(" #     # #     # #     # #     #  #  #    ## #          #     #  #   #   #   #   #   #  ");
		System.out.println(" #     # #     #  #####  #     # ### #     # #######     #####    ###     ###     ###   ");
		System.out.println("                                                                                        ");
	}

}
