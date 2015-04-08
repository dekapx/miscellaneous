package com.kapx.xembly.book;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xembly.ImpossibleModificationException;
import org.xembly.Xembler;

public class BookTest {
	private Book objectUnderTest;

	@Before
	public void setUp() throws Exception {
		objectUnderTest = new Book("0132350882", "Clean Code");
	}

	@After
	public void tearDown() throws Exception {
		objectUnderTest = null;
	}

	@Test
	public void testToXembly() throws Exception {
		try {
			final String xml = new Xembler(objectUnderTest.toXembly()).xml();
			assertNotNull(xml);
			System.out.println(xml);
		} catch (ImpossibleModificationException e) {
			throw new Exception(e);
		}
	}

}
