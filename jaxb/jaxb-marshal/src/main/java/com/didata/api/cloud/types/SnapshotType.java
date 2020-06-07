//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.01 at 03:43:19 PM BST 
//


package com.didata.api.cloud.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SnapshotType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SnapshotType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="snapshotId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="snapshotDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="sizeInBytes" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SnapshotType")
public class SnapshotType {

    @XmlAttribute(name = "snapshotId", required = true)
    protected String snapshotId;
    @XmlAttribute(name = "snapshotDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar snapshotDate;
    @XmlAttribute(name = "sizeInBytes", required = true)
    protected int sizeInBytes;

    /**
     * Gets the value of the snapshotId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /**
     * Sets the value of the snapshotId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnapshotId(String value) {
        this.snapshotId = value;
    }

    /**
     * Gets the value of the snapshotDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSnapshotDate() {
        return snapshotDate;
    }

    /**
     * Sets the value of the snapshotDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSnapshotDate(XMLGregorianCalendar value) {
        this.snapshotDate = value;
    }

    /**
     * Gets the value of the sizeInBytes property.
     * 
     */
    public int getSizeInBytes() {
        return sizeInBytes;
    }

    /**
     * Sets the value of the sizeInBytes property.
     * 
     */
    public void setSizeInBytes(int value) {
        this.sizeInBytes = value;
    }

}