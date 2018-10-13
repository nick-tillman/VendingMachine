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

	private static SortedMap<String, Slot> inventory = new TreeMap<String, Slot>();
	private Queue<Item> customerPurchases = new LinkedList<Item>();
	private double customerFunds = 0;

	/**
	 * Our Vending Machine constructor takes in a vending machine inventory file and then runs our 
	 * setupMachine method in order to populate our machine with slots and those slots with items.
	 * @param setupFile
	 */
	public VendingMachine(File setupFile) {
		setupMachine(setupFile);
	}

	public Map<String, Slot> getInventory() {
		return this.inventory;
	}

	public double getCustomerFunds() {
		return this.customerFunds;
	}
	
	public Queue<Item> getCustomerPurchases() {
		return customerPurchases;
	}
	
	/**
	 * Takes a slot number as input, checks if it is valid and returns the price of the corresponding slot.
	 * Will return null if not a valid slot.
	 * @param slotNumber
	 * @return
	 */
	public double getPurchasePrice(String slotNumber) {
		Set<String> keySet = inventory.keySet();
		Slot selectedSlot = null;
		if(keySet.contains(slotNumber)) {
			selectedSlot = inventory.get(slotNumber);
		}
		return selectedSlot.getPrice();
	}

	/**
	 * Takes a slot number as input, checks if it is valid and returns the item name of the corresponding slot.
	 * Will return null if not a valid slot.
	 * @param slotNumber
	 * @return
	 */
	public String getPurchaseItemName(String slotNumber) {
		Set<String> keySet = inventory.keySet();
		Slot selectedSlot = null;
		if(keySet.contains(slotNumber)) {
			selectedSlot = inventory.get(slotNumber);
		}
		return selectedSlot.getItemName();
	}
	
	/**
	 * Takes a slot number as input, checks if it is valid and returns the quantity variable of the corresponding 
	 * slot. Will return null if not a valid slot.
	 * @param slotNumber
	 * @return
	 */
	public int getPurchaseItemQty(String slotNumber) {
		Set<String> keySet = inventory.keySet();
		Slot selectedSlot = null;
		if(keySet.contains(slotNumber)) {
			selectedSlot = inventory.get(slotNumber);
		}
		return selectedSlot.getQuantity();
	}
	
	/**
	 * Takes a slot number as input, returns true if it is valid, false if it is not.
	 * @param userSelection
	 * @return
	 */
	public boolean isValidSlot(String userSelection) {
		Set<String> keySet = inventory.keySet();
		if (keySet.contains(userSelection)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Called in our constructor. Takes in the setup file passed to our Vending Machine constructor,
	 * scans it in line by line, converts that data to Item and Slot objects, and puts them into our
	 * inventory TreeMap.
	 */
	public static void setupMachine(File setupFile) {
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
	/**
	 * Takes a slot number as input, calls the dispense method to add an item to our customerPurchases queue
	 * and reduce that slot quantity by 1, subtracts the slot price from the customers funds and writes to
	 * our log and sales reports.
	 * @param userSelection
	 */
	public void purchaseItem(String userSelection) {
		Slot selection = inventory.get(userSelection);
		customerPurchases.add(selection.dispense());
		customerFunds -= selection.getPrice();
		// write to log
		// write to sales report
	}
	
	/**
	 * Takes a double as input, adds that amount to our customerFunds variable and writes to the log.
	 * @param feedMoney
	 */
	public void addFunds(Double feedMoney) {
		customerFunds += feedMoney;
		// write to log
	}
	
	/**
	 * Assigns our customer funds to a temporary variable, sets our customer funds to 0, and returns the value
	 * of what was left in customer funds.
	 * @return
	 */
	public double giveChange() {
		double change = customerFunds;
		customerFunds = 0;
		// write to log
		return change;
	}
	
	/**
	 * NOT WORKING YET. Intended to calculate the amount of coins in a given amount of change passed in.
	 * @param change
	 * @return
	 */
	public String calculateCoins(double change) {
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		String conversion = String.valueOf(change * 100);
		int coinsLeft = Integer.valueOf(conversion);
		quarters = coinsLeft/25;
		coinsLeft -= quarters*25;
		dimes = coinsLeft/10;
		coinsLeft -= dimes*10;
		nickels = coinsLeft/nickels;
		return quarters + " quarters, " + dimes + " dimes & " + nickels + " nickels";
	}

	/**
	 * Will print out a list of all inventory items, prints out a header and then loops through every 
	 * slot object in the Vending Machine and prints out its toString method.
	 */
	public void printInventoryList() {
		System.out.println("        SLOT\t  NAME\t\t\t\tPRICE\t\tQTY");
		System.out.println("        ====================================================================");
		Set<String> keySet = inventory.keySet();
		for (String key : keySet) {
			Slot newSlot = inventory.get(key);
			System.out.println("        " + newSlot.toString());
		}
	}
}
