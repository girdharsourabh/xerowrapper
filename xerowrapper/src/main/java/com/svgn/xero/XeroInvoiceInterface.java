package com.svgn.xero;

import java.util.Date;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.svgn.xero.domain.ApiExceptionExtended;
import com.svgn.xero.domain.ArrayOfInvoice;
import com.svgn.xero.domain.ResponseType;
import com.svgn.xero.exception.ResourceNotFoundException;
import com.svgn.xero.exception.XeroException;
import com.svgn.xero.util.DateUtils;
import com.svgn.xero.util.XeroRequestType;
import com.svgn.xero.util.XeroXmlManager;

public class XeroInvoiceInterface {
	
	
	public static void postInvoices(OAuthService service, Token accessToken, ArrayOfInvoice arrayOfInvoice) throws XeroException{
		OAuthRequest request = new OAuthRequest(Verb.POST, XeroRequestType.INVOICE.getURL());
		
		request.addBodyParameter("xml", XeroXmlManager.invoicesToXml(arrayOfInvoice));
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println(response.getBody());
		if (response.getBody().startsWith("<ApiException")){
			ApiExceptionExtended exception = XeroXmlManager.xmlToException(response.getBody());
			XeroException ex = new XeroException(response.getBody(),exception);
			throw ex;
		}else{
		ResponseType res = XeroXmlManager.xmlToResponse(response.getBody());
		System.out.println(res.getStatus());
		System.out.println(res.getProviderName());
		}
	}
	
	public static void createNewInvoices(OAuthService service, Token accessToken, ArrayOfInvoice arrayOfInvoice) throws XeroException{
		OAuthRequest request = new OAuthRequest(Verb.PUT, XeroRequestType.INVOICE.getURL());
		
		request.addBodyParameter("xml", XeroXmlManager.invoicesToXml(arrayOfInvoice));
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println(response.getBody());
		if (response.getBody().startsWith("<ApiException")){
			ApiExceptionExtended exception = XeroXmlManager.xmlToException(response.getBody());
			XeroException ex = new XeroException(response.getBody(),exception);
			throw ex;
		}else{
		ResponseType res = XeroXmlManager.xmlToResponse(response.getBody());
		System.out.println(res.getStatus());
		System.out.println(res.getProviderName());
		}
	}
	
	public static ArrayOfInvoice getInvoiceById(OAuthService service, Token accessToken, String invoiceId) throws ResourceNotFoundException{
		OAuthRequest request = new OAuthRequest(Verb.GET, XeroRequestType.INVOICE.getURL()+"/"+invoiceId);
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found")!=-1){
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return resp.getInvoices();
	}
	
	public static ArrayOfInvoice getInvoiceByDateAfter(OAuthService service, Token accessToken, Date date) throws ResourceNotFoundException{
		OAuthRequest request = new OAuthRequest(Verb.GET, XeroRequestType.INVOICE.getURL());
		request.addHeader("If-Modified-Since", DateUtils.getHeaderDateString(date));
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found")!=-1){
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return resp.getInvoices();
	}
}
