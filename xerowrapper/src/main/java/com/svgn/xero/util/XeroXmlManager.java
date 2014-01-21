
/*
 *  Copyright 2011 Ross Jourdain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.svgn.xero.util;

import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.svgn.xero.domain.ApiExceptionExtended;
import com.svgn.xero.domain.ArrayOfContact;
import com.svgn.xero.domain.ArrayOfInvoice;
import com.svgn.xero.domain.ArrayOfPayment;
import com.svgn.xero.domain.ObjectFactory;
import com.svgn.xero.domain.ResponseType;

/**
 *
 * @author ross
 */
public class XeroXmlManager {

    public static ArrayOfInvoice xmlToInvoices(InputStream invoiceStream) {

        ArrayOfInvoice arrayOfInvoices = null;

        try {
            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<ResponseType> element = unmarshaller.unmarshal(new StreamSource(invoiceStream), ResponseType.class);
            ResponseType response = element.getValue();
            arrayOfInvoices = response.getInvoices();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return arrayOfInvoices;
    }

    public static ResponseType xmlToResponse(InputStream responseStream) {

        ResponseType response = null;

        try {
            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<ResponseType> element = unmarshaller.unmarshal(new StreamSource(responseStream), ResponseType.class);
            response = element.getValue();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return response;
    }
    
    public static ResponseType xmlToResponse(String responseString) {

        ResponseType response = null;

        try {
            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<ResponseType> element = unmarshaller.unmarshal(new StreamSource(new StringReader(responseString)), ResponseType.class);
            response = element.getValue();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return response;
    }

    public static ApiExceptionExtended xmlToException(String exceptionString) {

        ApiExceptionExtended apiException = null;

        try {
            JAXBContext context = JAXBContext.newInstance(ApiExceptionExtended.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            JAXBElement<ApiExceptionExtended> element = unmarshaller.unmarshal(new StreamSource(new StringReader(exceptionString)), ApiExceptionExtended.class);
            apiException = element.getValue();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return apiException;
    }
    
 
    public static String contactsToXml(ArrayOfContact arrayOfContacts) {

        String contactsString = null;

        try {

            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);

            ObjectFactory factory = new ObjectFactory();
            JAXBElement<ArrayOfContact> element = factory.createContacts(arrayOfContacts);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(element, stringWriter);
            contactsString = stringWriter.toString();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return contactsString;
    }

    public static String invoicesToXml(ArrayOfInvoice arrayOfInvoices) {

        String invoicesString = null;

        try {

            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Marshaller marshaller = context.createMarshaller();
            //marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);

            ObjectFactory factory = new ObjectFactory();
            JAXBElement<ArrayOfInvoice> element = factory.createInvoices(arrayOfInvoices);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(element, stringWriter);
            invoicesString = stringWriter.toString();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return invoicesString;
    }

    public static String paymentsToXml(ArrayOfPayment arrayOfPayment) {

        String paymentsString = null;

        try {

            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);

            ObjectFactory factory = new ObjectFactory();
            JAXBElement<ArrayOfPayment> element = factory.createPayments(arrayOfPayment);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(element, stringWriter);
            paymentsString = stringWriter.toString();

        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return paymentsString;
    }
}
