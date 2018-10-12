package com.techelevator.vendingprogram;

public class Slot {
	
	private String slotNumber;
	private double price;
	private Item item;
	private int quantity;
	
	public Slot(String slotNumber, double price, Item item) {
		this.slotNumber = slotNumber;
		this.price = price;
		this.item = item;
		this.quantity = 5;
	}
	
	public String getSlotNumber() {
		return this.slotNumber;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public Item dispense() {
		this.quantity--;
		return this.item;
	}
	
	public String getItemName() {
		return this.item.getName();
	}
	
	public String getItemType() {
		return this.item.getType();
	}
	
	public String getItemSound() {
		return this.item.getSound();
	}
	
	@Override
	public String toString() {
		if(quantity > 0) {
			return slotNumber + ": " + getItemName() + "\t" + "$" + String.valueOf(getPrice()) + "\t" + String.valueOf(getQuantity()) + " left";
		} else {
			return slotNumber + ": " + getItemName() + "\t" + "$" + String.valueOf(getPrice()) + "\t" + "SOLD OUT";
		}
	}
	
}
