package ecim;

import java.util.List;

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

import ecim.UpgradePackageContentXSDType.ProductData;

public class UpgradePackageUnmarshaller {
	public static void main(String[] args) {
		try {
			final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			final Schema schema = schemaFactory.newSchema(new StreamSource("src/main/resources/ecim/nmsinfo.xsd"));
			final JAXBContext jaxbContext = JAXBContext.newInstance(UpgradePackage.class);

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
			UpgradePackage upgradePackage = (UpgradePackage) unmarshaller.unmarshal(new StreamSource("src/main/resources/ecim/nmsinfo.xml"));
			System.out.println(upgradePackage.getName());

			displayProductData(upgradePackage);
		} catch (SAXException | JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void displayProductData(UpgradePackage upgradePackage) {
		UpgradePackageContentXSDType upgradePackageContent = upgradePackage.getUpgradePackageContent();
		List<UpgradePackageContentXSDType.ProductData> productDataElements = upgradePackageContent.getProductData();
		for (ProductData productData : productDataElements) {
			System.out.println("productName: " + productData.getProductName());
			System.out.println("productNumber: " + productData.getProductNumber());
			System.out.println("productRevision: " + productData.getProductRevision());
			System.out.println("productionDate: " + productData.getProductionDate().toString());
			System.out.println("description: " + productData.getDescription());
			System.out.println("--------------------------------------------------------");
		}
	}
}
