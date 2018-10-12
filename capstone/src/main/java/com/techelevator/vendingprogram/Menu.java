package com.techelevator.vendingprogram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	
	public String getInputFromUser(String message) {
		Scanner inputReader = new Scanner(System.in);
		System.out.println(message);
		String userInput = inputReader.nextLine();
		return userInput;
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
	
	public void purchaseMenu() {
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
