package com.svgn.xero;

import java.util.Date;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.svgn.xero.domain.ApiExceptionExtended;
import com.svgn.xero.domain.ArrayOfAccount;
import com.svgn.xero.domain.ArrayOfContact;
import com.svgn.xero.domain.ArrayOfInvoice;
import com.svgn.xero.domain.ArrayOfItem;
import com.svgn.xero.domain.ArrayOfOrganisation;
import com.svgn.xero.domain.ArrayOfPayment;
import com.svgn.xero.domain.ArrayOfUser;
import com.svgn.xero.domain.ResponseType;
import com.svgn.xero.exception.RequestInvalidException;
import com.svgn.xero.exception.ResourceNotFoundException;
import com.svgn.xero.exception.XeroException;
import com.svgn.xero.search.SearchCriteria;
import com.svgn.xero.util.DateUtils;
import com.svgn.xero.util.XeroRequestType;
import com.svgn.xero.util.XeroXmlManager;

public class XeroInterface<T> {
	
	public ResponseType createNew(OAuthService service,
			Token accessToken, T t, XeroRequestType requestType) throws XeroException{
		if (!validateRequest(t,requestType)){
			throw new RequestInvalidException("Request parameters are not valid");
		}
		ResponseType res = null;
		OAuthRequest request = new OAuthRequest(Verb.PUT,
				requestType.getURL());

		request.addBodyParameter("xml",
				XeroXmlManager.arrayToXml(t));
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println(response.getBody());
		if (response.getBody().startsWith("<ApiException")) {
			ApiExceptionExtended exception = XeroXmlManager
					.xmlToException(response.getBody());
			XeroException ex = new XeroException(response.getBody(), exception);
			throw ex;
		} else {
			res = XeroXmlManager.xmlToResponse(response.getBody());
		}
		return res;
	}
	
	public ResponseType postEdit(OAuthService service,
			Token accessToken, T t, XeroRequestType requestType) throws XeroException{
		if (!validateRequest(t,requestType)){
			throw new RequestInvalidException("Request parameters are not valid");
		}
		ResponseType res = null;
		OAuthRequest request = new OAuthRequest(Verb.PUT,
				requestType.getURL());

		request.addBodyParameter("xml",
				XeroXmlManager.arrayToXml(t));
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println(response.getBody());
		if (response.getBody().startsWith("<ApiException")) {
			ApiExceptionExtended exception = XeroXmlManager
					.xmlToException(response.getBody());
			XeroException ex = new XeroException(response.getBody(), exception);
			throw ex;
		} else {
			res = XeroXmlManager.xmlToResponse(response.getBody());
		}
		return res;
	}
	
	public T getById(OAuthService service,
			Token accessToken, XeroRequestType requestType, String id) throws ResourceNotFoundException{
		OAuthRequest request = new OAuthRequest(Verb.GET, requestType.getURL()+"/"+id);
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found")!=-1){
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return extractObjects(resp,requestType);
	}
	
	public T getByCriteria(OAuthService service,
			Token accessToken, XeroRequestType requestType, SearchCriteria criteria) throws ResourceNotFoundException{
		OAuthRequest request = new OAuthRequest(Verb.GET, requestType.getURL());
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found")!=-1){
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return extractObjects(resp,requestType);
	}
	
	public T getAll(OAuthService service,
			Token accessToken, XeroRequestType requestType) throws ResourceNotFoundException{
		OAuthRequest request = new OAuthRequest(Verb.GET, requestType.getURL());
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found")!=-1){
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return extractObjects(resp,requestType);
	}
	
	
	private T extractObjects(ResponseType resp, XeroRequestType requestType) {
		switch (requestType){
		case ACCOUNTS:
			return (T) resp.getAccounts();
		case CONTACTS:
			return (T) resp.getContacts();
		case INVOICE:
			return (T) resp.getInvoices();
		case ITEMS:
			return (T) resp.getItems();
		case ORGANISATIONS:
			return (T) resp.getOrganisations();
		case PAYMENTS:
			return (T) resp.getPayments();
		case USERS:
			return (T) resp.getUsers();
		default:
			break;
		}
		return null;
	}

	private boolean validateRequest(T t, XeroRequestType requestType) {
		if (requestType.equals(requestType.INVOICE) && t.getClass().equals(ArrayOfInvoice.class)){
			return true;
		} else if (requestType.equals(requestType.PAYMENTS) && t.getClass().equals(ArrayOfPayment.class)){
			return true;
		} else if (requestType.equals(requestType.ITEMS) && t.getClass().equals(ArrayOfItem.class)){
			return true;
		} else if (requestType.equals(requestType.ACCOUNTS) && t.getClass().equals(ArrayOfAccount.class)){
			return true;
		} else if (requestType.equals(requestType.ORGANISATIONS) && t.getClass().equals(ArrayOfOrganisation.class)){
			return true;
		} else if (requestType.equals(requestType.USERS) && t.getClass().equals(ArrayOfUser.class)){
			return true;
		} else if (requestType.equals(requestType.CONTACTS) && t.getClass().equals(ArrayOfContact.class)){
			return true;
		}
		
		return false;
		
	}
	
	public T getInvoiceByDateAfter(OAuthService service, Token accessToken, XeroRequestType type, Date date) throws ResourceNotFoundException{
		OAuthRequest request = new OAuthRequest(Verb.GET, type.getURL());
		request.addHeader("If-Modified-Since", DateUtils.getHeaderDateString(date));
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found")!=-1){
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return extractObjects(resp, type);
	}
}
