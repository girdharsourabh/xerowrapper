package com.svgn.xero.exception;

import java.math.BigInteger;

import com.svgn.xero.domain.ApiExceptionExtended;

public class XeroException extends Throwable {

	public XeroException(String detailMessage,
			ApiExceptionExtended apiExceptionExtended) {
		super();
		this.detailMessage = detailMessage;
		this.apiExceptionExtended = apiExceptionExtended;
	}

	private String detailMessage;
	private ApiExceptionExtended apiExceptionExtended;

	public ApiExceptionExtended getApiExceptionExtended() {
		return apiExceptionExtended;
	}

	public void setApiExceptionExtended(
			ApiExceptionExtended apiExceptionExtended) {
		this.apiExceptionExtended = apiExceptionExtended;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	public String getMessage() {
		return this.getApiExceptionExtended().getMessage();
	}

	public String getType() {
		return this.getApiExceptionExtended().getType();
	}

	public BigInteger getErrorNumber() {
		return this.getApiExceptionExtended().getErrorNumber();
	}
}
