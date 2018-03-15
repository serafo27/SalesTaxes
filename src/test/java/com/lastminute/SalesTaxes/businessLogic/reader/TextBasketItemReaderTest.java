package com.lastminute.SalesTaxes.businessLogic.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.exception.BasketItemFormatException;
import com.lastminute.SalesTaxes.businessLogic.reader.concrete.TextBasketItemReader;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.Item;
import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class TextBasketItemReaderTest {

	
	
	@Test
	public void extractBasketItems_ValidInputWithThreeItem_ReturnThreeBasketItem() throws BasketItemFormatException {
		
		// Setup
		String text = "1;false;BOOK;book;12.49\n" + 
						"1;false;OTHER;music CD;14.99\n" + 
						"1;false;FOOD;chocolate bar;0.85";
		
		BasketItemReader reader = new TextBasketItemReader();
		
		// SUT
		List<BasketItem> basketItems = reader.extractBasketItems(text);
		
		
		// Assert
		assertEquals(basketItems.size(), 3);
		assertTrue(basketItems.contains(new BasketItem(1, new BigDecimal("12.49"), false, new Item("book", GoodsType.BOOK))));
		assertTrue(basketItems.contains(new BasketItem(1, new BigDecimal("14.99"), false, new Item("music CD", GoodsType.OTHER))));
		assertTrue(basketItems.contains(new BasketItem(1, new BigDecimal("0.85"), false, new Item("chocolate bar", GoodsType.FOOD))));	
	}
	
	@Test
	public void extractBasketItems_ValidImportedInputWithThreeItem_ReturnThreeBasketItem() throws BasketItemFormatException {
		
		// Setup
		String text = "1;true;BOOK;book;12.49\n" + 
						"1;true;OTHER;music CD;14.99\n" +
						"1;true;FOOD;chocolate bar;0.85";
		
		BasketItemReader reader = new TextBasketItemReader();
		
		// SUT
		List<BasketItem> basketItems = reader.extractBasketItems(text);
		
		
		// Assert
		assertEquals(basketItems.size(), 3);
		assertTrue(basketItems.contains(new BasketItem(1, new BigDecimal("12.49"), true, new Item("book", GoodsType.BOOK))));
		assertTrue(basketItems.contains(new BasketItem(1, new BigDecimal("14.99"), true, new Item("music CD", GoodsType.OTHER))));
		assertTrue(basketItems.contains(new BasketItem(1, new BigDecimal("0.85"), true, new Item("chocolate bar", GoodsType.FOOD))));	
	}
	
	
	
	@Test(expected = BasketItemFormatException.class)
	public void extractBasketItems_EmptyString_ThrowFormatException() throws BasketItemFormatException {
		
		// Setup
		String text = "";
		BasketItemReader reader = new TextBasketItemReader();
		
		// SUT
		// Assert
		reader.extractBasketItems(text);
		
	}
	
	
}
