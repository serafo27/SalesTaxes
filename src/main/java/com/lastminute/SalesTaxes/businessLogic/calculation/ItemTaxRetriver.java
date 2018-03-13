package com.lastminute.SalesTaxes.businessLogic.calculation;

import java.math.BigDecimal;

import com.lastminute.SalesTaxes.model.Item;

public interface ItemTaxRetriver {

	public BigDecimal getBasicTaxPercentage();
	public BigDecimal getImportTaxPercentage();
	
}
