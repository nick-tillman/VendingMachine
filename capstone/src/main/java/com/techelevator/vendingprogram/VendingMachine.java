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
	private static Map<Item, Integer> inventory = new HashMap<Item, Integer>();
	private Queue<Item> customerPurchases = new LinkedList<Item>();
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

	public void getList() {
		Set<Item> keySet = inventory.keySet();
		for (Item item : keySet) {
			System.out.println(inventory.get(item));
		}
	}

	public void purchaseItem(String userSelection) {
		Set<Item> keySet = inventory.keySet();
		for (Item item : keySet) {
			if (item.getSlot().equals(userSelection)) {
				int currentStock = inventory.get(item);
				inventory.put(item, currentStock - 1);
				customerPurchases.add(item);
				
			}
		}
	}
}
