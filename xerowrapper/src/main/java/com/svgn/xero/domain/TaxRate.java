//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.19 at 04:44:24 AM CST 
//


package com.svgn.xero.domain;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaxRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ValidationErrors" type="{}ArrayOfValidationError" minOccurs="0"/>
 *         &lt;element name="Warnings" type="{}ArrayOfWarning" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxType" type="{}taxType" minOccurs="0"/>
 *         &lt;element name="CanApplyToAssets" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanApplyToEquity" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanApplyToExpenses" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanApplyToLiabilities" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanApplyToRevenue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DisplayTaxRate" type="{}taxRate"/>
 *         &lt;element name="EffectiveRate" type="{}taxRate"/>
 *         &lt;element name="Status" type="{}taxRateStatus" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="status" type="{}entityValidationStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxRate", propOrder = {

})
public class TaxRate
    implements DataContractBase
{

    @XmlElement(name = "ValidationErrors")
    protected ArrayOfValidationError validationErrors;
    @XmlElement(name = "Warnings")
    protected ArrayOfWarning warnings;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "TaxType")
    protected String taxType;
    @XmlElement(name = "CanApplyToAssets")
    protected boolean canApplyToAssets;
    @XmlElement(name = "CanApplyToEquity")
    protected boolean canApplyToEquity;
    @XmlElement(name = "CanApplyToExpenses")
    protected boolean canApplyToExpenses;
    @XmlElement(name = "CanApplyToLiabilities")
    protected boolean canApplyToLiabilities;
    @XmlElement(name = "CanApplyToRevenue")
    protected boolean canApplyToRevenue;
    @XmlElement(name = "DisplayTaxRate", required = true, nillable = true)
    protected BigDecimal displayTaxRate;
    @XmlElement(name = "EffectiveRate", required = true, nillable = true)
    protected BigDecimal effectiveRate;
    @XmlElement(name = "Status")
    protected TaxRateStatus status;
    @XmlAttribute(name = "status")
    protected EntityValidationStatus validationStatus;

    /**
     * Gets the value of the validationErrors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfValidationError }
     *     
     */
    public ArrayOfValidationError getValidationErrors() {
        return validationErrors;
    }

    /**
     * Sets the value of the validationErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfValidationError }
     *     
     */
    public void setValidationErrors(ArrayOfValidationError value) {
        this.validationErrors = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfWarning }
     *     
     */
    public ArrayOfWarning getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfWarning }
     *     
     */
    public void setWarnings(ArrayOfWarning value) {
        this.warnings = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the taxType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxType() {
        return taxType;
    }

    /**
     * Sets the value of the taxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxType(String value) {
        this.taxType = value;
    }

    /**
     * Gets the value of the canApplyToAssets property.
     * 
     */
    public boolean isCanApplyToAssets() {
        return canApplyToAssets;
    }

    /**
     * Sets the value of the canApplyToAssets property.
     * 
     */
    public void setCanApplyToAssets(boolean value) {
        this.canApplyToAssets = value;
    }

    /**
     * Gets the value of the canApplyToEquity property.
     * 
     */
    public boolean isCanApplyToEquity() {
        return canApplyToEquity;
    }

    /**
     * Sets the value of the canApplyToEquity property.
     * 
     */
    public void setCanApplyToEquity(boolean value) {
        this.canApplyToEquity = value;
    }

    /**
     * Gets the value of the canApplyToExpenses property.
     * 
     */
    public boolean isCanApplyToExpenses() {
        return canApplyToExpenses;
    }

    /**
     * Sets the value of the canApplyToExpenses property.
     * 
     */
    public void setCanApplyToExpenses(boolean value) {
        this.canApplyToExpenses = value;
    }

    /**
     * Gets the value of the canApplyToLiabilities property.
     * 
     */
    public boolean isCanApplyToLiabilities() {
        return canApplyToLiabilities;
    }

    /**
     * Sets the value of the canApplyToLiabilities property.
     * 
     */
    public void setCanApplyToLiabilities(boolean value) {
        this.canApplyToLiabilities = value;
    }

    /**
     * Gets the value of the canApplyToRevenue property.
     * 
     */
    public boolean isCanApplyToRevenue() {
        return canApplyToRevenue;
    }

    /**
     * Sets the value of the canApplyToRevenue property.
     * 
     */
    public void setCanApplyToRevenue(boolean value) {
        this.canApplyToRevenue = value;
    }

    /**
     * Gets the value of the displayTaxRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDisplayTaxRate() {
        return displayTaxRate;
    }

    /**
     * Sets the value of the displayTaxRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDisplayTaxRate(BigDecimal value) {
        this.displayTaxRate = value;
    }

    /**
     * Gets the value of the effectiveRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEffectiveRate() {
        return effectiveRate;
    }

    /**
     * Sets the value of the effectiveRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEffectiveRate(BigDecimal value) {
        this.effectiveRate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TaxRateStatus }
     *     
     */
    public TaxRateStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRateStatus }
     *     
     */
    public void setStatus(TaxRateStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the validationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link EntityValidationStatus }
     *     
     */
    public EntityValidationStatus getValidationStatus() {
        return validationStatus;
    }

    /**
     * Sets the value of the validationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityValidationStatus }
     *     
     */
    public void setValidationStatus(EntityValidationStatus value) {
        this.validationStatus = value;
    }

}
