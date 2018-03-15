package com.lastminute.SalesTaxes.businessLogic.manager;

import java.util.List;

import com.lastminute.SalesTaxes.businessLogic.calculation.Calculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.ItemTaxRetriver;
import com.lastminute.SalesTaxes.businessLogic.calculation.ReceiptCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicItemTaxRetriver;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicReceiptCalculator;
import com.lastminute.SalesTaxes.businessLogic.calculation.concrete.BasicDecimalCalculator;
import com.lastminute.SalesTaxes.businessLogic.exception.BasketItemFormatException;
import com.lastminute.SalesTaxes.businessLogic.reader.BasketItemReader;
import com.lastminute.SalesTaxes.businessLogic.reader.concrete.TextBasketItemReader;
import com.lastminute.SalesTaxes.model.Basket;
import com.lastminute.SalesTaxes.model.BasketItem;
import com.lastminute.SalesTaxes.model.Receipt;

public class AppManager {

	
	
	public String generateReceiptText(String text) {
		
		BasketItemReader reader = new TextBasketItemReader();
		List<BasketItem> basketItems;
    	try {
	        basketItems = reader.extractBasketItems(text);
    	}
    	catch (BasketItemFormatException e) {
    		return "The input basket is not in the expected format.";
    	} 
        
    	
    	Basket basket = new Basket();
        for(BasketItem basketItem : basketItems)
        	basket.addBasketItem(basketItem);
        
        Calculator calculator = new BasicDecimalCalculator();
        ItemTaxRetriver itemTaxRetriver = new BasicItemTaxRetriver();
        ItemTaxCalculator itemTaxCalculator = new BasicItemTaxCalculator(itemTaxRetriver, calculator);
        ReceiptCalculator receiptCalculator = new BasicReceiptCalculator(itemTaxCalculator, calculator);
        
        Receipt receipt = receiptCalculator.generateReceipt(basket);
        return receipt.toString();
	}
	
	
	
}
