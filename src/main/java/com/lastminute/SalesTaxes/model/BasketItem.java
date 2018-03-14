package com.lastminute.SalesTaxes.model;

import java.math.BigDecimal;

public class BasketItem {

	private int quantity;
	private BigDecimal unitaryPrice;
	private boolean imported;
	private Item item;
	
	public BasketItem(int quantity, BigDecimal unitaryPrice, boolean imported, Item item) {
		
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.imported = imported;
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public boolean isImported() {
		return imported;
	}
	
	public BigDecimal getUnitaryPrice() {
		return unitaryPrice;
	}

	public Item getItem() {
		return item;
	}
	
	@Override
	public String toString() {
		
		return ((imported) ? "imported " : "") + item;
	}
}
