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
		return this.getPrice();
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
	
}
