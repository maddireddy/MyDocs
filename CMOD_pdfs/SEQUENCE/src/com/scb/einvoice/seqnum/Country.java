//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2011.12.16 at 06:59:16 PM IST
//

package com.scb.einvoice.seqnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="current-seq-number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="country-code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "currentSeqNumber" })
@XmlRootElement(name = "country")
public class Country {

    @XmlElement(name = "current-seq-number", nillable = false, namespace="http://www.standardchartered.com/seq-number")
    protected String currentSeqNumber;
    @XmlAttribute(name = "country-code", required = true)
    protected String countryCode;

    /**
     * Gets the value of the currentSeqNumber property.
     * 
     * @return
     *         possible object is {@link String }
     */
    public String getCurrentSeqNumber() {
        return currentSeqNumber;
    }

    /**
     * Sets the value of the currentSeqNumber property.
     * 
     * @param value
     *            allowed object is {@link String }
     */
    public void setCurrentSeqNumber(String value) {
        this.currentSeqNumber = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *         possible object is {@link String }
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *            allowed object is {@link String }
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

}
