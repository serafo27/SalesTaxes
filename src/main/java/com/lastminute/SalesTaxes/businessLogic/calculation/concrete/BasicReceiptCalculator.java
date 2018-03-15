package com.lastminute.SalesTaxes.businessLogic.calculation.concrete;

import java.math.BigDecimal;

import com.lastminute.SalesTaxes.businessLogic.calculation.Calculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.ReceiptCalculator;
import com.lastminute.SalesTaxes.model.Basket;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.Receipt;
import com.lastminute.SalesTaxes.model.ReceiptItem;

public class BasicReceiptCalculator implements ReceiptCalculator{

	private ItemTaxCalculator itemTaxCalculator;
	private Calculator calculator;
	
	public BasicReceiptCalculator(ItemTaxCalculator itemTaxCalculator, Calculator calculator) {
		
		this.calculator = calculator;
		this.itemTaxCalculator = itemTaxCalculator;
	}
	
	
	public Receipt generateReceipt(Basket basket) {
		
		Receipt result = new Receipt();
		BigDecimal salesTaxes = new BigDecimal("0.00"); 
		BigDecimal total = new BigDecimal("0.00");
		
		for(BasketItem basketItem : basket.getItems()) {
			
			BigDecimal taxAmount = itemTaxCalculator.calculateItemTaxAmount(basketItem);
			BigDecimal taxedItemAmount = calculator.add(basketItem.getUnitaryPrice(), taxAmount);
			BigDecimal totalItemAmount = calculator.multiply(taxedItemAmount, new BigDecimal(basketItem.getQuantity()));
			
			taxedItemAmount = calculator.scaleToTwoDecimal(taxedItemAmount);
			totalItemAmount = calculator.scaleToTwoDecimal(totalItemAmount);
			
			int quantity = basketItem.getQuantity();
			ReceiptItem receiptItem = new ReceiptItem(quantity, totalItemAmount, basketItem);
			
			salesTaxes = calculator.add(salesTaxes, taxAmount);
			total = calculator.add(total, totalItemAmount);
			
			result.addReceiptItem(receiptItem);
		}
		
		salesTaxes = calculator.scaleToTwoDecimal(salesTaxes);
		total = calculator.scaleToTwoDecimal(total);
		
		result.setSalesTaxes(salesTaxes);
		result.setTotal(total);
		
		return result;
	}

	
}
