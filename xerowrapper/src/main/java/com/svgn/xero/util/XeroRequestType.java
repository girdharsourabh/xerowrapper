package com.svgn.xero.util;

public enum XeroRequestType {
	
	INVOICE("https://api.xero.com/api.xro/2.0/Invoices");
	
	private String url;
	private XeroRequestType(String url){
		this.url = url;
	}
	
	public String getURL(){
		return url;
	}
	
}
