package com.svgn.xero.exception;

public class RequestInvalidException extends RuntimeException {
	
	public RequestInvalidException(String detail){
		super(detail);
	}
}
