package com.lastminute.SalesTaxes.businessLogic.calculation.concrete;

import java.math.BigDecimal;
import java.math.MathContext;

import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxRetriver;
import com.lastminute.SalesTaxes.model.Item;

public class BasicItemTaxRetriver implements ItemTaxRetriver {

	private BigDecimal basicTaxPercentage;
	private BigDecimal importTaxPercentage;
	
	public BasicItemTaxRetriver() {
		
		this.basicTaxPercentage = new BigDecimal(0.1d);
		this.importTaxPercentage = new BigDecimal(0.05d);
	}

	public BigDecimal getBasicTaxPercentage() {
		return basicTaxPercentage;
	}

	public BigDecimal getImportTaxPercentage() {
		return importTaxPercentage;
	}
	
	


}
