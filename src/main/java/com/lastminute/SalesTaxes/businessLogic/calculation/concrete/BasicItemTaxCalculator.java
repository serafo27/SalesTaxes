package com.lastminute.SalesTaxes.businessLogic.calculation.concrete;

import java.math.BigDecimal;

import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxRetriver;
import com.lastminute.SalesTaxes.businessLogic.calculation.Calculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxCalculator;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.enums.GoodsType;

public class BasicItemTaxCalculator implements ItemTaxCalculator {

	private ItemTaxRetriver itemTaxRetriver;
	private Calculator calculator;
	
	public BasicItemTaxCalculator(ItemTaxRetriver itemTaxRetriver, Calculator calculator) {
		
		this.itemTaxRetriver = itemTaxRetriver;
		this.calculator = calculator;
	}
	
	public BigDecimal calculateItemTaxAmount(BasketItem item) {
		
		BigDecimal basePrice = item.getUnitaryPrice();
		
		BigDecimal baseTaxAmount = new BigDecimal("0.00");
		BigDecimal importTaxAmount = new BigDecimal("0.00");
		
		if(item.getItem().GetGoodsType() == GoodsType.OTHER) {
			
			baseTaxAmount = calculator.multiply(basePrice, itemTaxRetriver.getBasicTaxPercentage());
			baseTaxAmount = calculator.roundToNearestZeroZeroFive(baseTaxAmount);
			baseTaxAmount = calculator.scaleToTwoDecimal(baseTaxAmount);
		}
		
		if(item.isImported()) {
			
			importTaxAmount = calculator.multiply(basePrice, itemTaxRetriver.getImportTaxPercentage());
			importTaxAmount = calculator.roundToNearestZeroZeroFive(importTaxAmount);
			importTaxAmount = calculator.scaleToTwoDecimal(importTaxAmount);
		}

		return calculator.add(baseTaxAmount, importTaxAmount);
	}
	
}
