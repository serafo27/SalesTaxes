package com.lastminute.SalesTaxes.businessLogic.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxRetriver;

public class BasicItemTaxRetriverTest {

	private static ItemTaxRetriver itemTaxResolver;
	
	@BeforeClass
	public static void Init()
	{
		itemTaxResolver = new BasicItemTaxRetriver();
	}
	
	@Test
	public void getBasicTaxPercentage_returnTenPercent()
	{
		// Setup
		BigDecimal expected = new BigDecimal("0.10");
		
		// SUT
		BigDecimal actual = itemTaxResolver.getBasicTaxPercentage();
		
		// Assert
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void getImportTaxPercentage_returnFivePercent()
	{
		// Setup
		BigDecimal expected = new BigDecimal("0.05");
		
		// SUT
		BigDecimal actual = itemTaxResolver.getImportTaxPercentage();
		
		// Assert
		assertEquals(expected, actual);
		
	}
	
	
}
