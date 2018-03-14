package com.lastminute.SalesTaxes.model;

import java.math.BigDecimal;

public class ReceiptItem {

	private int quantity;
	private BigDecimal amount;
	private BasketItem basketItem;
	
	
	public ReceiptItem(int quantity, BigDecimal amount, BasketItem basketItem) {
		
		this.quantity = quantity;
		this.amount = amount;
		this.basketItem = basketItem;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	public BasketItem getBasketItem() {
		return basketItem;
	}

	@Override
	public String toString() {
		return quantity + " " + basketItem + ": " + amount;
	}
	
	
}
