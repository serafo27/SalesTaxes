package com.lastminute.SalesTaxes.businessLogic.calculation;

import java.math.BigDecimal;

public interface ItemTaxRetriver {

	public BigDecimal getBasicTaxPercentage();
	public BigDecimal getImportTaxPercentage();
	
}
