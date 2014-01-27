package com.svgn.xero;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.svgn.xero.XeroInterface;
import com.svgn.xero.domain.ArrayOfInvoice;
import com.svgn.xero.domain.ArrayOfItem;
import com.svgn.xero.domain.ArrayOfLineItem;
import com.svgn.xero.domain.ArrayOfUser;
import com.svgn.xero.domain.Contact;
import com.svgn.xero.domain.Invoice;
import com.svgn.xero.domain.InvoiceType;
import com.svgn.xero.domain.LineItem;
import com.svgn.xero.domain.User;
import com.svgn.xero.exception.ResourceNotFoundException;
import com.svgn.xero.exception.XeroException;
import com.svgn.xero.util.XeroRequestType;

public class XeroTest2PostInvoiceWrapper {

	private static final String PROTECTED_RESOURCE_URL = "https://api.xero.com/api.xro/2.0/Invoices";//https://api.xero.com/api.xro/2.0/

	public static void main(String[] args)
	  {
	    // If you choose to use a callback, "oauth_verifier" will be the return value by Twitter (request param)
	    OAuthService service = new ServiceBuilder()
	                                .provider(ZeroApi.class).
	                                apiKey("RVDAMRAYBG0ZJVUAA3CTPKYMPLCFTR").
	                                apiSecret("ZN8H97DI2Z1WAMUWNRIAC5F79LSESJ")
	                                .debugStream(System.out)
	                                .callback("http://localhost:8080/test/authorize")
	                                .build();
	    Scanner in = new Scanner(System.in);
	    /*
	    System.out.println("=== Xero's OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Request Token
	    System.out.println("Fetching the Request Token...");
	    Token requestToken = service.getRequestToken();
	    //requestToken.
	    System.out.println(requestToken.getRawResponse());
	    System.out.println("Got the Request Token!");
	    System.out.println();

	    System.out.println("Now go and authorize Scribe here:");
	    System.out.println(service.getAuthorizationUrl(requestToken));
	    System.out.println("And paste the verifier here");
	    System.out.print(">>");
	    Verifier verifier = new Verifier(in.nextLine());
	    System.out.println();

	    // Trade the Request Token and Verfier for the Access Token
	    System.out.println("Trading the Request Token for an Access Token...");
	    Token accessToken = service.getAccessToken(requestToken, verifier);
	    System.out.println("Got the Access Token!");
	    System.out.println("(if your curious it looks like this: " + accessToken + " )");
	    System.out.println(accessToken.getToken());
	    System.out.println(accessToken.getSecret());

	    // Now let's go and ask for a protected resource!
	    System.out.println("Now we're going to access a protected resource...");
	    
	    /*OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
	    request.addBodyParameter("xml", "<Invoices><Invoice><Type>ACCREC</Type><Contact><Name>Martin Hudson</Name></Contact><Date>2014-01-20T00:00:00</Date><DueDate>2014-01-27T00:00:00</DueDate><LineAmountTypes>Exclusive</LineAmountTypes><LineItems><LineItem><Description>Monthly rental for property at 56a Wilkins Avenue</Description><Quantity>10.0000</Quantity><UnitAmount>500.00</UnitAmount><AccountCode>200</AccountCode></LineItem></LineItems></Invoice></Invoices>");
	    service.signRequest(accessToken, request);
	    Response response = request.send();
	    
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(response.getBody());

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
	    */
	    Token accessToken = new Token("RPXP5CPFRYFZE6TNONTWG1AT8FIZWV", "TV24T6H4AH9ICCG77PY9R0WSTKTFHI");
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
	    item.setUnitAmount(BigDecimal.valueOf(14));
	    item.setLineAmount(BigDecimal.valueOf(140));
	    item.setDescription("Testing wrapper1");
	    ArrayOfLineItem items = new ArrayOfLineItem();
	    items.getLineItem().add(item);
	    
	    inv.setLineItems(items);
	    array.getInvoice().add(inv);
	    
	    XeroInterface<ArrayOfInvoice> invoice = new XeroInterface<ArrayOfInvoice>();
	    try {
			invoice.createNew(service, accessToken, array, XeroRequestType.INVOICE);
		} catch (XeroException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			ArrayOfInvoice invs = invoice.getAll(service, accessToken, XeroRequestType.INVOICE);
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    XeroInterface<ArrayOfUser> user = new XeroInterface<ArrayOfUser>();
	    ArrayOfUser users;
		try {
			users = user.getAll(service, accessToken, XeroRequestType.USERS);
			 List<User> listOfUsers = users.getUser();
			    for (User us : listOfUsers){
			    	System.out.println(us.getFirstName());
			    	System.out.println(us.getLastName());
			    }
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    try{
	    user.getById(service, accessToken, XeroRequestType.ACCOUNTS, "123");
	    } catch (Exception e){
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
	    } catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try{
	    user.getById(service, accessToken, XeroRequestType.ACCOUNTS, "123");
	  } catch (Exception e){
	    	e.printStackTrace();
	    	System.out.println(e.getMessage());
	    } catch (ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }
}
