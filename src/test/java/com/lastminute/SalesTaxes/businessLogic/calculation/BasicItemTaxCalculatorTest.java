package com.lastminute.SalesTaxes.businessLogic.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxRetriver;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.TwoDecimalCalculator;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.Item;
import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class BasicItemTaxCalculatorTest {

	private static Calculator calculator;
	private static ItemTaxRetriver itemTaxRetriver;
	private static ItemTaxCalculator itemTaxCalulator;
	
	@BeforeClass
	public static void Init()
	{
		itemTaxRetriver = new BasicItemTaxRetriver();
		calculator = new TwoDecimalCalculator();
		itemTaxCalulator = new BasicItemTaxCalculator(itemTaxRetriver, calculator);
	}
	
	
	@Test
	public void calculateItemTaxAmount_BookItemNotImported_ZeroTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.BOOKS);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), false, item);
		
		BigDecimal expected = new BigDecimal("0.00");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void calculateItemTaxAmount_FoodItemNotImported_ZeroTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.FOOD);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), false, item);
		
		BigDecimal expected = new BigDecimal("0.00");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void calculateItemTaxAmount_MedicalItemNotImported_ZeroTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.MEDICAL);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), false, item);
		
		BigDecimal expected = new BigDecimal("0.00");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void calculateItemTaxAmount_OtherItemNotImported_BasicGoodsTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.OTHER);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), false, item);
		
		BigDecimal expected = new BigDecimal("1.00");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	
	}
	
	
	@Test
	public void calculateItemTaxAmount_BookItemImported_ImportedTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.BOOKS);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), true, item);
		
		BigDecimal expected = new BigDecimal("0.50");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void calculateItemTaxAmount_FoodItemImported_ImportedTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.FOOD);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), true, item);
		
		BigDecimal expected = new BigDecimal("0.50");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void calculateItemTaxAmount_MedicalItemImported_ImportedTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.MEDICAL);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), true, item);
		
		BigDecimal expected = new BigDecimal("0.50");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void calculateItemTaxAmount_OtherItemImported_BasicGoodsTaxAndImportedTax() {
		
		// Setup
		Item item = new Item("item1", GoodsType.OTHER);
		BasketItem basketItem = new BasketItem(1, new BigDecimal("10.00"), true, item);
		
		BigDecimal expected = new BigDecimal("1.50");
		
		// SUT
		BigDecimal actual = itemTaxCalulator.calculateItemTaxAmount(basketItem);
		
		
		// Assert
		assertEquals(expected, actual);
	
	}
	
	
	
}
