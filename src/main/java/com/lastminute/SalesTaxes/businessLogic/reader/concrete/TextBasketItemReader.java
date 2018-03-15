package com.lastminute.SalesTaxes.businessLogic.reader.concrete;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lastminute.SalesTaxes.businessLogic.exception.BasketItemFormatException;
import com.lastminute.SalesTaxes.businessLogic.reader.BasketItemReader;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.Item;
import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class TextBasketItemReader implements BasketItemReader{

	public List<BasketItem> extractBasketItems(String text) throws BasketItemFormatException {
		
		List<BasketItem> basketItems = new ArrayList<BasketItem>();
		
		for(String line : text.split("\n"))
		{
			String[] infos = line.trim().split(";");
			
			try {
				int quantity = Integer.parseInt(infos[0]);
				boolean imported = Boolean.parseBoolean(infos[1]);
				GoodsType type = GoodsType.valueOf(infos[2]);
				String description = infos[3];
				BigDecimal unitaryPrice = new BigDecimal(infos[4]);

				Item tmpItem = new Item(description, type);
				basketItems.add(new BasketItem(quantity, unitaryPrice, imported, tmpItem));
			}
			catch (Exception e) {
				throw new BasketItemFormatException(e.getMessage());
			}
			
		}
		
		return basketItems;
		
	}

}
