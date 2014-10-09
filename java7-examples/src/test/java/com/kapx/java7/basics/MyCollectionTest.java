package com.kapx.java7.basics;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class MyCollectionTest {
	private MyCollection myCollection;

	@Before
	public void setUp() throws Exception {
		myCollection = new MyCollection();
	}

	@After
	public void tearDown() throws Exception {
		myCollection = null;
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddElementForNull() {
		myCollection.addElement(null);
	}

	@Test
	public void testAddElementForNotNull() {
		myCollection.addElement("test");
		List<String> elements = Whitebox.getInternalState(myCollection, "elements");
		assertEquals(1, elements.size());
	}
	
}
