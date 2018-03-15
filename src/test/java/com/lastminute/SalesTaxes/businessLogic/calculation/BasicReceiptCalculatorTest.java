package com.lastminute.SalesTaxes.businessLogic.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxRetriver;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicReceiptCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicDecimalCalculator;
import com.lastminute.SalesTaxes.model.Basket;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.Item;
import com.lastminute.SalesTaxes.model.Receipt;
import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class BasicReceiptCalculatorTest {

	private static Calculator calculator;
	private static ItemTaxCalculator itemTaxCalculator;
	private static ItemTaxRetriver itemTaxRetriver;
	private static ReceiptCalculator receiptCalculator;
	
	@BeforeClass
	public static void Init() {
		
		calculator = new BasicDecimalCalculator();
		itemTaxRetriver = new BasicItemTaxRetriver();
		itemTaxCalculator = new BasicItemTaxCalculator(itemTaxRetriver, calculator);
		receiptCalculator = new BasicReceiptCalculator(itemTaxCalculator, calculator);
	}
	
	
	
	
	@Test
	public void generateReceipt_MixedItems_CorrectResult() {
		
		// Setup
		Item bookItem = new Item("book", GoodsType.BOOK);
		Item foodItem = new Item("food", GoodsType.FOOD);
		Item otherItem = new Item("other", GoodsType.OTHER);
		
		Basket basket = new Basket();
		BasketItem basketItem1 = new BasketItem(1, new BigDecimal("10.00"), false, bookItem);
		BasketItem basketItem2 = new BasketItem(1, new BigDecimal("10.00"), false, foodItem);
		BasketItem basketItem3 = new BasketItem(1, new BigDecimal("10.00"), false, otherItem);
		BasketItem basketItem4 = new BasketItem(1, new BigDecimal("10.00"), true, foodItem);
		BasketItem basketItem5 = new BasketItem(1, new BigDecimal("10.00"), true, otherItem);
		
		basket.addBasketItem(basketItem1);
		basket.addBasketItem(basketItem2);
		basket.addBasketItem(basketItem3);
		basket.addBasketItem(basketItem4);
		basket.addBasketItem(basketItem5);
		
		BigDecimal expectedBookAmount = new BigDecimal("10.00");
		BigDecimal expectedFoodAmount = new BigDecimal("10.00");
		BigDecimal expectedOtherAmount = new BigDecimal("11.00");
		BigDecimal expectedImportedFoodAmount = new BigDecimal("10.50");
		BigDecimal expectedImportedOtherAmount = new BigDecimal("11.50");
		BigDecimal expectedSalesTaxes = new BigDecimal("3.00");
		BigDecimal expectedTotal = new BigDecimal("53.00");
		
		
		// SUT
		Receipt actual = receiptCalculator.generateReceipt(basket);
		
		// Assert
		assertEquals(expectedBookAmount, actual.getReceiptItems().get(0).getAmount());
		assertEquals(expectedFoodAmount, actual.getReceiptItems().get(1).getAmount());
		assertEquals(expectedOtherAmount, actual.getReceiptItems().get(2).getAmount());
		assertEquals(expectedImportedFoodAmount, actual.getReceiptItems().get(3).getAmount());
		assertEquals(expectedImportedOtherAmount, actual.getReceiptItems().get(4).getAmount());
		assertEquals(expectedSalesTaxes, actual.getSalesTaxes());
		assertEquals(expectedTotal, actual.getTotal());
		
	}
	
	
	
	
}
