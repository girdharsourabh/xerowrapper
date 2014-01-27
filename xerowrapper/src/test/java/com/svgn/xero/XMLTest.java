package com.svgn.xero;

import java.math.BigDecimal;
import java.util.Calendar;

import com.svgn.xero.domain.ArrayOfInvoice;
import com.svgn.xero.domain.ArrayOfLineItem;
import com.svgn.xero.domain.Contact;
import com.svgn.xero.domain.Invoice;
import com.svgn.xero.domain.InvoiceType;
import com.svgn.xero.domain.LineItem;
import com.svgn.xero.util.XeroXmlManager;

public class XMLTest {
	public static void main(String[] args) {
		ArrayOfInvoice array = new ArrayOfInvoice();
	    Invoice inv = new Invoice();
	    inv.setType(InvoiceType.ACCREC);
	    Contact cntact = new Contact();
	    cntact.setName("Sourabh Girdhar");
	    inv.setContact(cntact);
	    inv.setDate(Calendar.getInstance());
	    inv.setDueDate(Calendar.getInstance());
	    inv.getLineAmountTypes().add("Exclusive");
	    LineItem item = new LineItem();
	    item.setAccountCode("200");
	    item.setQuantity(BigDecimal.TEN);
	    item.setUnitAmount(BigDecimal.valueOf(13));
	    item.setLineAmount(BigDecimal.valueOf(130));
	    item.setDescription("Testing wrapper1");
	    ArrayOfLineItem items = new ArrayOfLineItem();
	    items.getLineItem().add(item);
	    
	    inv.setLineItems(items);
	    array.getInvoice().add(inv);
	    
	    
	    String str = XeroXmlManager.arrayToXml(array);
	    System.out.println(str);
	    String st2 = XeroXmlManager.invoicesToXml(array);
	    System.out.println(st2);
	}
}
