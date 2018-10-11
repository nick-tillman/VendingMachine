package com.techelevator.vendingprogram;

public class Item {

	private String name;
	private String type;
	
	public Item(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
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
	
