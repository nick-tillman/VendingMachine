package com.techelevator.vendingprogram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.text.SimpleDateFormat;

public class Logs {

	private String strDateFormat = "MM/dd/yyyy hh:mm:ss: a";
	private Date objDate = new Date();
	private SimpleDateFormat SDF = new SimpleDateFormat();
	private SortedMap<String, Integer> inventoryQty = new TreeMap<String, Integer>();
	private SortedMap<String, Double> inventoryPrices = new TreeMap<String, Double>();

	/**
	 * Takes in a name and price and adds them to the log objects inventoryQty map and invetoryPrices map.
	 */
	public void setupLogInventory(String name, double price) {
		this.inventoryQty.put(name, 0);
		this.inventoryPrices.put(name, price);
	}

	/**
	 * Updates the quantity of the passed of the value of the passed in name by 1 in the inventoryQty map.
	 * @param name
	 */
	public void addToLogInventory(String name) {
		int oldValue = inventoryQty.get(name);
		int newValue = oldValue + 1;
		inventoryQty.put(name, newValue);
	}
	
	/**
	 * Prints out to the console the total quantity sold of each item and total sales combined of all items.
	 */
	public void makeSalesReport() {
		Set<String> keySet = inventoryQty.keySet();
		double totalSum = 0;
		System.out.println();
		System.out.println("SALES REPORT");
		System.out.println("============");
		for(String name : keySet) {
			int qty = inventoryQty.get(name);
			double price = inventoryPrices.get(name);
			totalSum += qty * price;
			System.out.println(name + "|" + qty);
		}
		System.out.println("**TOTAL SALES**  $" + String.format("%.2f", totalSum));
	}
	
}
