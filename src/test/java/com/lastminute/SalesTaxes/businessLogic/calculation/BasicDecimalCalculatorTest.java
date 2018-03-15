package com.lastminute.SalesTaxes.businessLogic.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicDecimalCalculator;

public class BasicDecimalCalculatorTest {

	private static DecimalFormat decimalFormat;
	private static Calculator calculator;
	
	@BeforeClass
	public static void Init()
	{
		calculator = new BasicDecimalCalculator();
		
		decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(2);
	}
	
	
	
	public void roundToNearestZeroZeroFive_PositiveNumbers_correctlyRounded() {
		// Setup
		BigDecimal num1 = new BigDecimal("0.5625");
		BigDecimal num2 = new BigDecimal("1.0");
		BigDecimal num3 = new BigDecimal("4.75");
		BigDecimal num4 = new BigDecimal("2.375");
		BigDecimal expected1 = new BigDecimal("0.55");
		BigDecimal expected2 = new BigDecimal("1.0");
		BigDecimal expected3 = new BigDecimal("4.75");
		BigDecimal expected4 = new BigDecimal("2.35");
		
		// SUT
		BigDecimal actual1 = calculator.roundToNearestZeroZeroFive(num1);
		BigDecimal actual2 = calculator.roundToNearestZeroZeroFive(num2);
		BigDecimal actual3 = calculator.roundToNearestZeroZeroFive(num3);
		BigDecimal actual4 = calculator.roundToNearestZeroZeroFive(num4);
		
		// Assert
		assertEquals(decimalFormat.format(expected1), decimalFormat.format(actual1));
		assertEquals(decimalFormat.format(expected2), decimalFormat.format(actual2));
		assertEquals(decimalFormat.format(expected3), decimalFormat.format(actual3));
		assertEquals(decimalFormat.format(expected4), decimalFormat.format(actual4));
	}
	
	
	
	@Test
	public void add_twoPositiveNumber_PositiveNumber() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("10.00");
		BigDecimal num2 = new BigDecimal("10.00");
		BigDecimal expected = new BigDecimal("20.00");
		
		// SUT
		BigDecimal actual = calculator.add(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
		assertTrue(actual.signum() == 1);
	}
	
	@Test
	public void add_twoNegativeNumber_NegativeNumber() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("-10.00");
		BigDecimal num2 = new BigDecimal("-10.00");
		BigDecimal expected = new BigDecimal("-20.00");
		
		// SUT
		BigDecimal actual = calculator.add(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
		assertTrue(actual.signum() == -1);
	}
	
	@Test
	public void multiply_twoPositiveNumber_PositiveNumber() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("2.00");
		BigDecimal num2 = new BigDecimal("2.00");
		BigDecimal expected = new BigDecimal("4.00");
		
		// SUT
		BigDecimal actual = calculator.multiply(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
		assertTrue(actual.signum() == 1);
	}
	
	@Test
	public void multiply_twoNegativeNumber_PositiveNumber() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("-2.00");
		BigDecimal num2 = new BigDecimal("-2.00");
		BigDecimal expected = new BigDecimal("4.00");
		
		// SUT
		BigDecimal actual = calculator.multiply(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
		assertTrue(actual.signum() == 1);
	}
	
	@Test
	public void multiply_numbersWithMixedSignum_NegativeNumber() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("-2.00");
		BigDecimal num2 = new BigDecimal("2.00");
		BigDecimal expected = new BigDecimal("-4.00");
		
		// SUT
		BigDecimal actual = calculator.multiply(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
		assertTrue(actual.signum() == -1);
	}
	
	
}
