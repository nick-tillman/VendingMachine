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
					if(selection.getQuantity() > 0) {
						customerPurchases.add(selection.dispense());
						customerFunds -= selection.getPrice();
						profit += selection.getPrice();
						//write to log
						//write to sales report
					} else {
						System.out.println("SOLD OUT! Please make a different selection!");
					}
			}
		}
	}
	
	public void addFunds(Double feedMoney) {
		//write to log
		customerFunds += feedMoney;
	}
	
	public double giveChange() {
		double change = customerFunds;
		customerFunds = 0;
		//write to log
		return change;
	}
	
	public String calculateCoins(double change) {
		return "";
	}
	
	public void getList() {
		System.out.println("SLOT\t\tNAME\t\tPRICE\t\tQTY.");
		System.out.println("****************************************************");
		Set<String> keySet = inventory.keySet();
		for(String key : keySet) {
			Slot newSlot = inventory.get(key);
			System.out.println(newSlot.toString());
		}
	}
}
