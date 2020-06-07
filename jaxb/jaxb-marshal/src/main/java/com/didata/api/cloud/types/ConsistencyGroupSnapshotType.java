//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.01 at 03:43:19 PM BST 
//

package com.didata.api.cloud.types;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for ConsistencyGroupSnapshotType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsistencyGroupSnapshotType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="snapshotType" type="{urn:didata.com:api:cloud:types}SnapshotType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="journalUsage" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="protectionWindow" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *       &lt;attribute name="predictedProtectionWindow" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsistencyGroupSnapshotType", propOrder = { "snapshotType" })
@XmlRootElement
public class ConsistencyGroupSnapshotType {

	@XmlElement(required = true)
	protected List<SnapshotType> snapshotType;
	@XmlAttribute(name = "journalUsage")
	protected Integer journalUsage;
	@XmlAttribute(name = "protectionWindow")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar protectionWindow;
	@XmlAttribute(name = "predictedProtectionWindow")
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar predictedProtectionWindow;

	/**
	 * Gets the value of the snapshotType property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be
	 * present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the snapshotType property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSnapshotType().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link SnapshotType }
	 * 
	 * 
	 */
	public List<SnapshotType> getSnapshotType() {
		if (snapshotType == null) {
			snapshotType = new ArrayList<SnapshotType>();
		}
		return this.snapshotType;
	}

	/**
	 * Gets the value of the journalUsage property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getJournalUsage() {
		return journalUsage;
	}

	/**
	 * Sets the value of the journalUsage property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setJournalUsage(Integer value) {
		this.journalUsage = value;
	}

	/**
	 * Gets the value of the protectionWindow property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getProtectionWindow() {
		return protectionWindow;
	}

	/**
	 * Sets the value of the protectionWindow property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setProtectionWindow(XMLGregorianCalendar value) {
		this.protectionWindow = value;
	}

	/**
	 * Gets the value of the predictedProtectionWindow property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getPredictedProtectionWindow() {
		return predictedProtectionWindow;
	}

	/**
	 * Sets the value of the predictedProtectionWindow property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setPredictedProtectionWindow(XMLGregorianCalendar value) {
		this.predictedProtectionWindow = value;
	}

}