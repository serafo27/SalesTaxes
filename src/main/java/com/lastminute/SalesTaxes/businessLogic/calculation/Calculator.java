package com.lastminute.SalesTaxes.businessLogic.calculation;

import java.math.BigDecimal;

public interface Calculator {

	public BigDecimal add(BigDecimal num1, BigDecimal num2);
	public BigDecimal multiply(BigDecimal num1, BigDecimal num2);
	
}
