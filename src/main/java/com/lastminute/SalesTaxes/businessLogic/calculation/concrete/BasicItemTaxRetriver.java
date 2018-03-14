package com.lastminute.SalesTaxes.businessLogic.calculation.concrete;

import java.math.BigDecimal;
import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxRetriver;

public class BasicItemTaxRetriver implements ItemTaxRetriver {

	private BigDecimal basicTaxPercentage;
	private BigDecimal importTaxPercentage;
	
	public BasicItemTaxRetriver() {
		
		this.basicTaxPercentage = new BigDecimal("0.10");
		this.importTaxPercentage = new BigDecimal("0.05");
	}

	public BigDecimal getBasicTaxPercentage() {
		return basicTaxPercentage;
	}

	public BigDecimal getImportTaxPercentage() {
		return importTaxPercentage;
	}
	
	


}
