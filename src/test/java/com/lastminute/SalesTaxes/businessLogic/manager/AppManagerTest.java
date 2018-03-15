package com.lastminute.SalesTaxes.businessLogic.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class AppManagerTest {

	private static AppManager manager;
	
	@BeforeClass
	public static void Init() {
		
		manager = new AppManager();
	}
	
	
	@Test
	public void generateReceiptText_invalidInput_ErrorMessage() {
	
		// Setup
		String text = "String text = \"1;0;BafsdOOK;book;12.49\\n1;0;OTHER;muxzcdaic CD;14.99";
		String expected = "The input basket is not in the expected format.";
		
		// SUT
		String actual = manager.generateReceiptText(text);

		// Assert
		assertEquals(expected, actual);
	}

	
	@Test
	public void generateReceiptText_validInput1_CorrectOutput() {
		
		// Setup
		String text = "1;false;BOOK;book;12.49\n" +
						"1;false;OTHER;music CD;14.99\n" + 
						"1;false;FOOD;chocolate bar;0.85\n";
		
		String expected = "1 book: 12.49\n" + 
				"1 music CD: 16.49\n" + 
				"1 chocolate bar: 0.85\n" + 
				"Sales Taxes: 1.50\n" + 
				"Total: 29.83\n";
		
		// SUT
		String actual = manager.generateReceiptText(text);

		// Assert
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void generateReceiptText_validInput2_CorrectOutput() {
		
		// Setup
		String text = "1;true;FOOD;box of chocolates;10.00\n" + 
						"1;true;OTHER;bottle of perfume;47.50\n";
		
		String expected = "1 imported box of chocolates: 10.50\n" + 
				"1 imported bottle of perfume: 54.65\n" + 
				"Sales Taxes: 7.65\n" + 
				"Total: 65.15\n";
		
		// SUT
		String actual = manager.generateReceiptText(text);

		// Assert
		assertEquals(expected, actual);
			
	}
	
	
	@Test
	public void generateReceiptText_validInput3_CorrectOutput() {
		
		// Setup
		String text = "1;true;OTHER;bottle of perfume;27.99\n" + 
						"1;false;OTHER;bottle of perfume;18.99\n" +
						"1;false;MEDICAL;packet of headache pills;9.75\n" +
						"1;true;FOOD;box of chocolates;11.25\n";
		
		String expected = "1 imported bottle of perfume: 32.19\n" + 
				"1 bottle of perfume: 20.89\n" + 
				"1 packet of headache pills: 9.75\n" + 
				"1 imported box of chocolates: 11.80\n" + 
				"Sales Taxes: 6.65\n" + 
				"Total: 74.63\n";
		
		// SUT
		String actual = manager.generateReceiptText(text);

		// Assert
		assertEquals(expected, actual);
	}
	
	
}
