package com.lastminute.SalesTaxes.businessLogic.calculation;

import com.lastminute.SalesTaxes.model.Basket;
import com.lastminute.SalesTaxes.model.Receipt;

public interface ReceiptCalculator {

	public Receipt generateReceipt(Basket basket);
	
}
