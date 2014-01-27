package com.svgn.xero;

import java.util.Date;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.svgn.xero.domain.ArrayOfPayment;
import com.svgn.xero.domain.ArrayOfUser;
import com.svgn.xero.domain.ResponseType;
import com.svgn.xero.exception.ResourceNotFoundException;
import com.svgn.xero.util.DateUtils;
import com.svgn.xero.util.XeroRequestType;
import com.svgn.xero.util.XeroXmlManager;

public class XeroUserInterface {

	public static ArrayOfUser getAllUsers(OAuthService service,
			Token accessToken) throws ResourceNotFoundException {
		OAuthRequest request = new OAuthRequest(Verb.GET,
				XeroRequestType.USERS.getURL());
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found") != -1) {
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return resp.getUsers();
	}

	public static ArrayOfUser getUserById(OAuthService service,
			Token accessToken, String userId) throws ResourceNotFoundException {
		OAuthRequest request = new OAuthRequest(Verb.GET,
				XeroRequestType.USERS.getURL()+"/"+userId);
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found") != -1) {
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return resp.getUsers();
	}
	
	public static ArrayOfUser getPaymentByDateAfter(OAuthService service,
			Token accessToken, Date date) throws ResourceNotFoundException {
		OAuthRequest request = new OAuthRequest(Verb.GET,
				XeroRequestType.PAYMENTS.getURL());
		request.addHeader("If-Modified-Since",
				DateUtils.getHeaderDateString(date));
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found") != -1) {
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return resp.getUsers();
	}

}
