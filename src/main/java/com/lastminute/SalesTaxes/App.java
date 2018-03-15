package com.lastminute.SalesTaxes;

import com.lastminute.SalesTaxes.businessLogic.manager.AppManager;

public class App 
{
    public static void main( String[] args )
    {
        
    	AppManager manager = new AppManager();
    	String result = manager.generateReceiptText(args[0]);
    	
    	System.out.println(result);
    	
    }
}
