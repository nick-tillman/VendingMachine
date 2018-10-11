package com.techelevator.vendingprogram;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {

	private static File setupFile = null;
	private static Map<String, Slot> inventory = new HashMap<String, Slot>();
	private Queue<Item> customerPurchases = new LinkedList<Item>();
	private double customerFunds;
	private double profit;

	public VendingMachine(File setupFile) {
		this.setupFile = setupFile;
		setupMachine();
	}

	public static void setupMachine() {
		try (Scanner fileScanner = new Scanner(setupFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] itemArray = line.split("\\|");
				Item newItem = new Item(itemArray[1], itemArray[3]);
				Slot newSlot = new Slot(itemArray[0], Double.parseDouble(itemArray[2]), newItem);
				inventory.put(newSlot.getSlotNumber(), newSlot);
			}
		} catch (Exception ex) {
			System.out.println("An exception occurred!");
		}
	}

	public void purchaseItem(String userSelection) {
		Set<String> keySet = inventory.keySet();
		for (String key : keySet) {
			if (key.equalsIgnoreCase(userSelection)) {
				Slot selection = inventory.get(userSelection);
				customerPurchases.add(selection.dispense());
				customerFunds -= selection.getPrice();
				profit += selection.getPrice();
				// write transaction to log

			}
		}
	}
	
	public void addFunds(Double feedMoney) {
		customerFunds += feedMoney;
	}
	
	public double giveChange() {
		return this.customerFunds;
	}
	
	public String calculateCoins(double change) {
		
		return "";
	}
}
