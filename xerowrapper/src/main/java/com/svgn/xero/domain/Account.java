//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.19 at 04:44:24 AM CST 
//


package com.svgn.xero.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Account">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ValidationErrors" type="{}ArrayOfValidationError" minOccurs="0"/>
 *         &lt;element name="Warnings" type="{}ArrayOfWarning" minOccurs="0"/>
 *         &lt;element name="AccountID" type="{}uniqueIdentifier" minOccurs="0"/>
 *         &lt;element name="Code" type="{}accountCode" minOccurs="0"/>
 *         &lt;element name="Name" type="{}accountName" minOccurs="0"/>
 *         &lt;element name="Status" type="{}accountStatus" minOccurs="0"/>
 *         &lt;element name="Type" type="{}accountType" minOccurs="0"/>
 *         &lt;element name="TaxType" type="{}taxType" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Class" type="{}accountClass" minOccurs="0"/>
 *         &lt;element name="SystemAccount" type="{}accountSystemCode" minOccurs="0"/>
 *         &lt;element name="EnablePaymentsToAccount" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowInExpenseClaims" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BankAccountNumber" type="{}bankAccountNumber" minOccurs="0"/>
 *         &lt;element name="CurrencyCode" type="{}currencyCode" minOccurs="0"/>
 *         &lt;element name="ReportingCode" type="{}reportCode" minOccurs="0"/>
 *         &lt;element name="ReportingCodeName" type="{}reportCodeName" minOccurs="0"/>
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
@XmlType(name = "Account", propOrder = {

})
public class Account
    implements DataContractBase
{

    @XmlElement(name = "ValidationErrors")
    protected ArrayOfValidationError validationErrors;
    @XmlElement(name = "Warnings")
    protected ArrayOfWarning warnings;
    @XmlElement(name = "AccountID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String accountID;
    @XmlElement(name = "Code")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String code;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Status")
    protected AccountStatus status;
    @XmlElement(name = "Type")
    protected AccountType type;
    @XmlElement(name = "TaxType")
    protected String taxType;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Class")
    protected AccountClass clazz;
    @XmlElement(name = "SystemAccount")
    protected AccountSystemCode systemAccount;
    @XmlElement(name = "EnablePaymentsToAccount")
    protected Boolean enablePaymentsToAccount;
    @XmlElement(name = "ShowInExpenseClaims")
    protected Boolean showInExpenseClaims;
    @XmlElement(name = "BankAccountNumber")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String bankAccountNumber;
    @XmlElement(name = "CurrencyCode")
    protected CurrencyCode currencyCode;
    @XmlElement(name = "ReportingCode")
    protected String reportingCode;
    @XmlElement(name = "ReportingCodeName")
    protected String reportingCodeName;
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
     * Gets the value of the accountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountID(String value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AccountStatus }
     *     
     */
    public AccountStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountStatus }
     *     
     */
    public void setStatus(AccountStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AccountType }
     *     
     */
    public AccountType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountType }
     *     
     */
    public void setType(AccountType value) {
        this.type = value;
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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link AccountClass }
     *     
     */
    public AccountClass getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountClass }
     *     
     */
    public void setClazz(AccountClass value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the systemAccount property.
     * 
     * @return
     *     possible object is
     *     {@link AccountSystemCode }
     *     
     */
    public AccountSystemCode getSystemAccount() {
        return systemAccount;
    }

    /**
     * Sets the value of the systemAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountSystemCode }
     *     
     */
    public void setSystemAccount(AccountSystemCode value) {
        this.systemAccount = value;
    }

    /**
     * Gets the value of the enablePaymentsToAccount property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnablePaymentsToAccount() {
        return enablePaymentsToAccount;
    }

    /**
     * Sets the value of the enablePaymentsToAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnablePaymentsToAccount(Boolean value) {
        this.enablePaymentsToAccount = value;
    }

    /**
     * Gets the value of the showInExpenseClaims property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowInExpenseClaims() {
        return showInExpenseClaims;
    }

    /**
     * Sets the value of the showInExpenseClaims property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowInExpenseClaims(Boolean value) {
        this.showInExpenseClaims = value;
    }

    /**
     * Gets the value of the bankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Sets the value of the bankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountNumber(String value) {
        this.bankAccountNumber = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCode }
     *     
     */
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCode }
     *     
     */
    public void setCurrencyCode(CurrencyCode value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the reportingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingCode() {
        return reportingCode;
    }

    /**
     * Sets the value of the reportingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingCode(String value) {
        this.reportingCode = value;
    }

    /**
     * Gets the value of the reportingCodeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportingCodeName() {
        return reportingCodeName;
    }

    /**
     * Sets the value of the reportingCodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportingCodeName(String value) {
        this.reportingCodeName = value;
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