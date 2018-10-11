package com.techelevator.vendingprogram;

public class Item {

	private String slot;
	private String name;
	private double price;
	private String type;
	
	public Item(String slot, String name, double price, String type) {
		this.slot = slot;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getSlot() {
		return slot;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getSound() {
		if (type == "chip") {
			return "Crunch, Crunch, Yum!";
		}
		if (type == "candy") {
			return "Munch Munch, Yum!";
		}
		if (type == "drink") {
			return "Glug Glug, Yum!";
		}
		if (type == "gum") {
			return "Chew Chew, Yum!";
		}
		return "";
	}

}
	
