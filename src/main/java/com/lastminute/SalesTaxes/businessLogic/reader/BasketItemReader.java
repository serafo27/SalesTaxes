package com.lastminute.SalesTaxes.businessLogic.reader;

import java.util.List;

import com.lastminute.SalesTaxes.businessLogic.exception.BasketItemFormatException;
import com.lastminute.SalesTaxes.model.BasketItem;

public interface BasketItemReader {

	
	public List<BasketItem> extractBasketItems(String text) throws BasketItemFormatException;
}
