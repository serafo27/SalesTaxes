package com.lastminute.SalesTaxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

	private ArrayList<BasketItem> items;
	
	public Basket() {
		
		this.items = new ArrayList<BasketItem>();
	}
	
	public void addItem(int quantity, BigDecimal unitaryPrice, boolean imported, Item item) {
		
		items.add(new BasketItem(quantity, unitaryPrice, imported, item));
	}
	
	public List<BasketItem> getItems() {
		return items;
	}
	
}
