package com.lastminute.SalesTaxes.businessLogic.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxRetriver;

public class BasicTaxRetriverTest {

	
	
	@Test
	public void getBasicTaxPercentage_returnTenPercent()
	{
		// Setup
		ItemTaxRetriver itemTaxResolver = new BasicItemTaxRetriver();
		BigDecimal expected = new BigDecimal(0.1d);
		
		// SUT
		BigDecimal actual = itemTaxResolver.getBasicTaxPercentage();
		
		// Assert
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void getImportTaxPercentage_returnFivePercent()
	{
		// Setup
		ItemTaxRetriver itemTaxResolver = new BasicItemTaxRetriver();
		BigDecimal expected = new BigDecimal(0.05d);
		
		// SUT
		BigDecimal actual = itemTaxResolver.getImportTaxPercentage();
		
		// Assert
		assertEquals(expected, actual);
		
	}
	
	
}
