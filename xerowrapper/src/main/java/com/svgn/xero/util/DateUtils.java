package com.svgn.xero.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
	
	public static String getHeaderDateString(Date date){
		return df.format(date);
	}
	
	public static void main(String[] args) {
		System.out.println(getHeaderDateString(new Date()));
	}
}
