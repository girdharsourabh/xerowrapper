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
 * <p>Java class for accountStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="accountStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="ARCHIVED"/>
 *     &lt;enumeration value="DELETED"/>
 *     &lt;enumeration value="PENDING"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "accountStatus")
@XmlEnum
public enum AccountStatus {


    /**
     * Active
     * 
     */
    ACTIVE,

    /**
     * Archived
     * 
     */
    ARCHIVED,

    /**
     * Deleted
     * 
     */
    DELETED,

    /**
     * Pending
     * 
     */
    PENDING;

    public String value() {
        return name();
    }

    public static AccountStatus fromValue(String v) {
        return valueOf(v);
    }

}
