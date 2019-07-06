package com.ericsson.trainings.jaxb.client;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.didata.api.cloud.types.ConsistencyGroupSnapshotType;
import com.didata.api.cloud.types.SnapshotType;
import com.ericsson.trainings.jaxb.beans.Address;
import com.ericsson.trainings.jaxb.beans.Contact;
import com.ericsson.trainings.jaxb.beans.Department;
import com.ericsson.trainings.jaxb.beans.Employee;
import com.ericsson.trainings.jaxb.beans.Student;
import com.ericsson.trainings.jaxb.marshaller.JaxbMarshaller;

public class JaxbClient {

	public static void main(String[] args) {
		ConsistencyGroupSnapshotType object = geConsistencyGroupSnapshotType();
		final File xmlFile = new File("src/main/resources/xml/snapshots.xml");
		JaxbMarshaller.marshall(object, xmlFile);

		// marshallStudent();
		// System.out.println("----------------------------------");
		// masrhallContact();
		// System.out.println("----------------------------------");
		// marshallEmployeeDept();
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

	public static void marshallStudent() {
		final Student student = createStudent();

		final File xmlFile = new File("src/main/resources/xml/student.xml");
		JaxbMarshaller.marshall(student, xmlFile);
	}

	public static void masrhallContact() {
		final Contact contact = createContact();

		final File xmlFile = new File("src/main/resources/xml/contact.xml");
		JaxbMarshaller.marshall(contact, xmlFile);
	}

	public static void marshallEmployeeDept() {
		final Department department = createDeptEmployee();

		final File xmlFile = new File("src/main/resources/xml/dept-emp.xml");
		JaxbMarshaller.marshall(department, xmlFile);
	}

	private static Student createStudent() {
		final Student student = new Student();
		student.setId(1L);
		student.setFirstName("De");
		student.setLastName("Kapx");
		student.setMarks(98.99);
		return student;
	}

	private static Contact createContact() {
		final Contact contact = new Contact();
		contact.setFirstName("De");
		contact.setLastName("Kapx");
		contact.setEmail("dekapx@gmail.com");
		contact.setContactNumber(123456789);

		final Address address = new Address();
		address.setHouseNo("LM Ericsson Ltd.");
		address.setStreet("Ericsson Software Campus");
		address.setCity("Athlone");
		address.setZipCode("N37 PV44");
		address.setCounty("Westmeath");
		contact.setAddress(address);
		return contact;
	}

	private static Department createDeptEmployee() {
		final Department department = new Department();
		department.setId(1L);
		department.setName("Engineering");

		final Employee employee1 = new Employee();
		employee1.setId(1L);
		employee1.setFirstName("fname1");
		employee1.setLastName("lname1");
		employee1.setEmail("fname1.lname1@test.com");
		employee1.setDesignation("Trainee Engineer");
		department.getEmployee().add(employee1);

		final Employee employee2 = new Employee();
		employee2.setId(2L);
		employee2.setFirstName("fname2");
		employee2.setLastName("lname2");
		employee2.setEmail("fname2.lname2@test.com");
		employee2.setDesignation("Senior Engineer");
		department.getEmployee().add(employee2);
		return department;
	}

}
