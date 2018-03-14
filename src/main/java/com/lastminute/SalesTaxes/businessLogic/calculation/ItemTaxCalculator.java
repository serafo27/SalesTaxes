package com.lastminute.SalesTaxes.businessLogic.calculation;

import java.math.BigDecimal;

import com.lastminute.SalesTaxes.model.BasketItem;

public interface ItemTaxCalculator {
	
	public BigDecimal calculateItemTaxAmount(BasketItem item);

}
