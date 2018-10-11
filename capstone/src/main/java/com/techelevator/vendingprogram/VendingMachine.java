package com.techelevator.vendingprogram;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
	
	private static File setupFile = null;
	private static Map<Item, Integer> inventory = new HashMap<Item, Integer>();
	private double transactionBalance;
	private double totalSum;
	
	public VendingMachine(File setupFile) {
		this.setupFile = setupFile;
		setupMachine();
	}
	
	public static void setupMachine() {
		try (Scanner fileScanner = new Scanner(setupFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] itemArray = line.split("\\|");
				Item newItem = new Item(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]), itemArray[3]);
				inventory.put(newItem, 5);
			}
		} catch (Exception ex) {
			System.out.println("An exception occurred!");
		}
	}
	

}
