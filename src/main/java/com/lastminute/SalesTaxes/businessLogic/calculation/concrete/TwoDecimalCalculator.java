package com.lastminute.SalesTaxes.businessLogic.calculation.concrete;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.lastminute.SalesTaxes.businessLogic.calculation.Calculator;

public class TwoDecimalCalculator implements Calculator{

	private int decimals;
	private RoundingMode roundingMode;
	
	public TwoDecimalCalculator() {
		
		this.decimals = 2;
		this.roundingMode = RoundingMode.HALF_UP;
	}

	public BigDecimal add(BigDecimal num1, BigDecimal num2) {
		return num1.add(num2).setScale(decimals, roundingMode);
	}

	public BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
		return num1.multiply(num2).setScale(decimals, roundingMode);
	}
	
	
	
}
