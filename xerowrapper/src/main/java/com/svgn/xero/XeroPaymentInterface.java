package com.svgn.xero;

import java.util.Date;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.svgn.xero.domain.ApiExceptionExtended;
import com.svgn.xero.domain.ArrayOfPayment;
import com.svgn.xero.domain.ResponseType;
import com.svgn.xero.exception.ResourceNotFoundException;
import com.svgn.xero.exception.XeroException;
import com.svgn.xero.util.DateUtils;
import com.svgn.xero.util.XeroRequestType;
import com.svgn.xero.util.XeroXmlManager;

public class XeroPaymentInterface {

	public static ResponseType postPayments(OAuthService service,
			Token accessToken, ArrayOfPayment arrayOfPayment)
			throws XeroException {
		ResponseType res = null;
		OAuthRequest request = new OAuthRequest(Verb.POST,
				XeroRequestType.PAYMENTS.getURL());

		request.addBodyParameter("xml",
				XeroXmlManager.paymentsToXml(arrayOfPayment));
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

	public static ResponseType createNewPayments(OAuthService service,
			Token accessToken, ArrayOfPayment arrayOfPayment)
			throws XeroException {
		ResponseType res = null;
		OAuthRequest request = new OAuthRequest(Verb.PUT,
				XeroRequestType.PAYMENTS.getURL());

		request.addBodyParameter("xml",
				XeroXmlManager.paymentsToXml(arrayOfPayment));
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

	public static ArrayOfPayment getPaymentById(OAuthService service,
			Token accessToken, String paymentId)
			throws ResourceNotFoundException {
		OAuthRequest request = new OAuthRequest(Verb.GET,
				XeroRequestType.PAYMENTS.getURL() + "/" + paymentId);
		service.signRequest(accessToken, request);
		Response response = request.send();
		if (response.getBody().indexOf("cannot be found") != -1) {
			throw new ResourceNotFoundException(response.getBody());
		}
		ResponseType resp = XeroXmlManager.xmlToResponse(response.getBody());
		return resp.getPayments();
	}

	public static ArrayOfPayment getPaymentByDateAfter(OAuthService service,
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
		return resp.getPayments();
	}
}
