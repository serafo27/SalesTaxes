package com.lastminute.SalesTaxes.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

	private ArrayList<BasketItem> items;
	
	public Basket() {
		
		this.items = new ArrayList<BasketItem>();
	}
	
	public void addBasketItem(BasketItem basketItem) {
		
		items.add(basketItem);
	}
	
	public List<BasketItem> getItems() {
		return items;
	}
	
}
