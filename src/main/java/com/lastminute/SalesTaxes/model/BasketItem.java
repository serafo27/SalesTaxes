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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (imported ? 1231 : 1237);
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((unitaryPrice == null) ? 0 : unitaryPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasketItem other = (BasketItem) obj;
		if (imported != other.imported)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		if (unitaryPrice == null) {
			if (other.unitaryPrice != null)
				return false;
		} else if (!unitaryPrice.equals(other.unitaryPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return ((imported) ? "imported " : "") + item;
	}
}
