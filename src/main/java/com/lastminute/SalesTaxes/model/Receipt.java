package com.lastminute.SalesTaxes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<ReceiptItem> receiptItems;
	private BigDecimal salesTaxes;
	private BigDecimal total;
	
	public Receipt() {
		
		this.receiptItems = new ArrayList<ReceiptItem>();
		this.salesTaxes = new BigDecimal(0d);
		this.total = new BigDecimal(0d);
	}
	
	public void addReceiptItem(ReceiptItem receiptItem) {
		this.receiptItems.add(receiptItem);
	}

	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(BigDecimal salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ReceiptItem> getReceiptItems() {
		return receiptItems;
	}
	
}
