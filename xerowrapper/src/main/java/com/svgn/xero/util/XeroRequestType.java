package com.svgn.xero.util;

public enum XeroRequestType {
	
	INVOICE("https://api.xero.com/api.xro/2.0/Invoices"),
	PAYMENTS("https://api.xero.com/api.xro/2.0/Payments"),
	ITEMS("https://api.xero.com/api.xro/2.0/Items"),
	ACCOUNTS("https://api.xero.com/api.xro/2.0/Accounts"),
	CONTACTS("https://api.xero.com/api.xro/2.0/Contacts"),
	ORGANISATIONS("https://api.xero.com/api.xro/2.0/Organisation"),
	USERS("https://api.xero.com/api.xro/2.0/Users");
	
	private String url;
	private XeroRequestType(String url){
		this.url = url;
	}
	
	public String getURL(){
		return url;
	}
	
}
