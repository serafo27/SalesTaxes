package com.lastminute.SalesTaxes.model;

import java.math.BigDecimal;
import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class Item {

	private String description;
	private BigDecimal unitaryPrice;
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
	
}
