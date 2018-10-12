package com.techelevator.vendingprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	
	private Map<Integer, String> mainMenu = new HashMap<Integer, String>();
	private Map<Integer, String> purchaseMenu = new HashMap<Integer, String>();
	
	public String getInputFromUser(String message) {
		Scanner inputReader = new Scanner(System.in);
		System.out.println(message);
		String userInput = inputReader.nextLine();
		return userInput;
	}
	
	public void buildOptions() {
		mainMenu.put(1, "Display Vending Machine Items");
		mainMenu.put(2, "Purchase");
		purchaseMenu.put(1, "Feed Money");
		purchaseMenu.put(2, "Select Product");
		purchaseMenu.put(3, "Finish Transaction");
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println();
		System.out.println("1 >>> Display Vending Machine Items");
		System.out.println("2 >>> Purchase");
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
