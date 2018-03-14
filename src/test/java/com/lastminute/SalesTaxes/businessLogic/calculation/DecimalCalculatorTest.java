package com.lastminute.SalesTaxes.businessLogic.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.TwoDecimalCalculator;

public class DecimalCalculatorTest {

	private static DecimalFormat decimalFormat;
	private static Calculator calculator;
	
	@BeforeClass
	public static void Init()
	{
		calculator = new TwoDecimalCalculator();
		
		decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(2);
	}
	
	
	@Test
	public void add_TwoNumberWithFiveDecimal_NumberWithTwoDecimal() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("10.11123");
		BigDecimal num2 = new BigDecimal("10.11929");
		BigDecimal expected = new BigDecimal("20.23");
		
		// SUT
		BigDecimal actual = calculator.add(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
	}
	
	@Test
	public void multiply_TwoNumberWithFiveDecimal_NumberWithTwoDecimal() {
		
		// Setup
		BigDecimal num1 = new BigDecimal("4.11123");
		BigDecimal num2 = new BigDecimal("4.11921");
		BigDecimal expected = new BigDecimal("16.94");
		
		// SUT
		BigDecimal actual = calculator.multiply(num1, num2);
		
		// Assert
		assertEquals(decimalFormat.format(expected), decimalFormat.format(actual));
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
