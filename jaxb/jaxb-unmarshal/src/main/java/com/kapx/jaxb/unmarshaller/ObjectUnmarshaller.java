package com.kapx.jaxb.unmarshaller;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.kapx.jaxb.po.PurchaseOrderType;

public class ObjectUnmarshaller {
	public static void main(String[] args) {
		try {
			final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			final Schema schema = schemaFactory.newSchema(new StreamSource("src/main/resources/po.xsd"));
			final JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrderType.class);

			final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setSchema(schema);
			unmarshaller.setEventHandler(new ValidationEventHandler() {

				@Override
				public boolean handleEvent(ValidationEvent event) {
					System.out.println("\nEVENT");
					System.out.println("SEVERITY: " + event.getSeverity());
					System.out.println("MESSAGE: " + event.getMessage());
					System.out.println("LINKED EXCEPTION: " + event.getLinkedException());
					System.out.println("LOCATOR");
					System.out.println("LINE NUMBER: " + event.getLocator().getLineNumber());
					System.out.println("COLUMN NUMBER: " + event.getLocator().getColumnNumber());
					System.out.println("OFFSET: " + event.getLocator().getOffset());
					System.out.println("OBJECT: " + event.getLocator().getObject());
					System.out.println("NODE: " + event.getLocator().getNode());
					System.out.println("URL: " + event.getLocator().getURL());
					return true;
				}
			});
			PurchaseOrderType purchaseOrder = (PurchaseOrderType) unmarshaller.unmarshal(new StreamSource("src/main/resources/po.xml"));
			System.out.println(purchaseOrder);
		} catch (SAXException | JAXBException e) {
			e.printStackTrace();
		}
	}
}
