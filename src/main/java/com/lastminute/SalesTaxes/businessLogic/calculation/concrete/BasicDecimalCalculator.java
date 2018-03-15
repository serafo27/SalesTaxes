package com.lastminute.SalesTaxes.businessLogic.calculation.concrete;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.lastminute.SalesTaxes.businessLogic.calculation.Calculator;

public class BasicDecimalCalculator implements Calculator{

	private BigDecimal nearestValue;
	private int decimals;
	private RoundingMode roundingMode;
	
	public BasicDecimalCalculator() {
		
		this.decimals = 2;
		this.nearestValue = new BigDecimal("20");
		this.roundingMode = RoundingMode.HALF_UP;
	}

	public BigDecimal add(BigDecimal num1, BigDecimal num2) {
		return num1.add(num2);
	}
	
	public BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
		return num1.multiply(num2);
	}

	public BigDecimal roundToNearestZeroZeroFive(BigDecimal num) {
		
		BigDecimal integerPart = new BigDecimal(Math.round(num.multiply(nearestValue).doubleValue()));
		return integerPart.divide(nearestValue);
	}
	
	public BigDecimal scaleToTwoDecimal(BigDecimal num) {
		return num.setScale(decimals, roundingMode);
	}
	
	
}
