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
	public String toString() {

		return description;
	}
}
