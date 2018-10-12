package com.techelevator.vendingprogram;

import java.io.File;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class VendingMachine {

	private static File setupFile = null;
	private static SortedMap<String, Slot> inventory = new TreeMap<String, Slot>();
	private Queue<Item> customerPurchases = new LinkedList<Item>();
	private double customerFunds = 0;
	private double profit;

	public VendingMachine(File setupFile) {
		this.setupFile = setupFile;
		setupMachine();
	}

	public Map<String, Slot> getInventory() {
		return this.inventory;
	}

	public double getCustomerFunds() {
		return this.customerFunds;
	}

	public double getProfit() {
		return this.profit;
	}
	
	
	public Queue<Item> getCustomerPurchases() {
		return customerPurchases;
	}

	public double getPurchasePrice(String slotNumber) {
		Set<String> keySet = inventory.keySet();
		Slot selectedSlot = null;
		for (String key : keySet) {
			if (slotNumber.equals(key)) {
				selectedSlot = inventory.get(slotNumber);
			}
		}
		return selectedSlot.getPrice();
	}

	public String getPurchaseItemName(String slotNumber) {
		Set<String> keySet = inventory.keySet();
		Slot selectedSlot = null;
		for (String key : keySet) {
			if (slotNumber.equals(key)) {
				selectedSlot = inventory.get(slotNumber);
			}
		}
		return selectedSlot.getItemName();
	}
	
	public int getPurchaseItemQty(String slotNumber) {
		Set<String> keySet = inventory.keySet();
		Slot selectedSlot = null;
		for (String key : keySet) {
			if (slotNumber.equals(key)) {
				selectedSlot = inventory.get(slotNumber);
			}
		}
		return selectedSlot.getQuantity();
	}
	
	public boolean isValidSlot(String userSelection) {
		Set<String> keySet = inventory.keySet();
		if (keySet.contains(userSelection)) {
			return true;
		}
		return false;
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
		if (keySet.contains(userSelection)) {
			Slot selection = inventory.get(userSelection);
			customerPurchases.add(selection.dispense());
			customerFunds -= selection.getPrice();
			profit += selection.getPrice();
			// write to log
			// write to sales report
		}
	}

	public void addFunds(Double feedMoney) {
		// write to log
		customerFunds += feedMoney;
	}

	public double giveChange() {
		double change = customerFunds;
		customerFunds = 0;
		// write to log
		return change;
	}

	public String calculateCoins(double change) {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		String conversion = String.valueOf(change * 100);
		int coinsLeft = Integer.valueOf(conversion) % 100;
		quarters = coinsLeft/25;
		coinsLeft -= quarters*25;
		dimes = coinsLeft/10;
		coinsLeft -= dimes*10;
		nickels = coinsLeft/nickels;
		return quarters + " quarters, " + dimes + " dimes & " + nickels + " nickels";
	}

	public void printInventoryList() {
		System.out.println("SLOT\t\tNAME\t\tPRICE\t\tQTY.");
		System.out.println("****************************************************");
		Set<String> keySet = inventory.keySet();
		for (String key : keySet) {
			Slot newSlot = inventory.get(key);
			System.out.println(newSlot.toString());
		}
	}
}
