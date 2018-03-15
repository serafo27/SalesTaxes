package com.lastminute.SalesTaxes.model;

import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class Item {

	private String description;
	private GoodsType type;
	
	public Item(String description, GoodsType type) {
		
		this.description = description;
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public GoodsType GetGoodsType() {
		return type;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Item other = (Item) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {

		return description;
	}
}
