//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.19 at 04:44:24 AM CST 
//


package com.svgn.xero.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bankTransactionStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bankTransactionStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="AUTHORISED"/>
 *     &lt;enumeration value="VOIDED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "bankTransactionStatus")
@XmlEnum
public enum BankTransactionStatus {

    AUTHORISED,
    VOIDED;

    public String value() {
        return name();
    }

    public static BankTransactionStatus fromValue(String v) {
        return valueOf(v);
    }

}
