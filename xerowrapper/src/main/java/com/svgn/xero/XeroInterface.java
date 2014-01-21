package com.svgn.xero;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference.Elements;
import com.svgn.xero.domain.ApiException;
import com.svgn.xero.domain.ApiExceptionExtended;
import com.svgn.xero.domain.ArrayOfInvoice;
import com.svgn.xero.domain.ResponseType;
import com.svgn.xero.util.XeroRequestType;
import com.svgn.xero.util.XeroXmlManager;

public class XeroInterface {
	
	
	public static void postInvoices(OAuthService service, Token accessToken, ArrayOfInvoice arrayOfInvoice){
		OAuthRequest request = new OAuthRequest(Verb.POST, XeroRequestType.INVOICE.getURL());
		
		request.addBodyParameter("xml", XeroXmlManager.invoicesToXml(arrayOfInvoice));
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println(response.getBody());
		if (response.getBody().startsWith("<ApiException")){
			ApiExceptionExtended exception = XeroXmlManager.xmlToException(response.getBody());
			System.out.println(exception.getType());
			System.out.println(exception.getMessage());
			System.out.println(exception.getErrorNumber());
			ApiExceptionExtended.Elements elements = exception.getElements();
			System.out.println(elements.getDataContractBase());
			
			
		}else{
		ResponseType res = XeroXmlManager.xmlToResponse(response.getBody());
		System.out.println(res.getStatus());
		System.out.println(res.getProviderName());
		}
	}
}
