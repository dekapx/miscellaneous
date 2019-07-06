package com.kapx.json.convertor;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.didata.api.cloud.types.ConsistencyGroupSnapshotType;
import com.didata.api.cloud.types.SnapshotType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConvertor {
	public static void main(String[] args) throws Exception {
		ConsistencyGroupSnapshotType object = geConsistencyGroupSnapshotType();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("src/main/resources/json/snapshots.json"), object);

		// Object to JSON in String
		String jsonInString = mapper.writeValueAsString(object);
		System.out.println(jsonInString);
	}

	private static ConsistencyGroupSnapshotType geConsistencyGroupSnapshotType() {
		ConsistencyGroupSnapshotType consistencyGroupSnapshotType = new ConsistencyGroupSnapshotType();
		consistencyGroupSnapshotType.setJournalUsage(100);
		consistencyGroupSnapshotType.setProtectionWindow(toXMLGregorianCalendar(new Date()));
		consistencyGroupSnapshotType.setPredictedProtectionWindow(toXMLGregorianCalendar(new Date()));

		SnapshotType snapshotType = new SnapshotType();
		snapshotType.setSnapshotId("1");
		snapshotType.setSnapshotDate(toXMLGregorianCalendar(new Date()));
		snapshotType.setSizeInBytes(100);
		consistencyGroupSnapshotType.getSnapshotType().add(snapshotType);

		return consistencyGroupSnapshotType;
	}

	public static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} catch (DatatypeConfigurationException ex) {
			ex.printStackTrace();
		}
		return xmlCalendar;
	}

}
