package com.kapx.weld.cdi.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kapx.weld.cdi.beans.FileWriter;
import com.kapx.weld.cdi.beans.TextFileWriter;
import com.kapx.weld.cdi.beans.XmlFileWriter;

public class BeanFactoryTest {
	private BeanFactory beanFactory;

	@Before
	public void setUp() throws Exception {
		beanFactory = BeanFactory.INSTANCE;
	}

	@After
	public void tearDown() throws Exception {
		beanFactory = null;
	}

	@Test
	public void testGetBeanInstanceByName() {
		final FileWriter xmlFileWriter = beanFactory.getBeanInstanceByName("xmlFileWriter");
		assertNotNull(xmlFileWriter);
		assertTrue(xmlFileWriter instanceof XmlFileWriter);
		xmlFileWriter.write("sample text");

		final FileWriter textFileWriter = beanFactory.getBeanInstanceByName("textFileWriter");
		assertNotNull(textFileWriter);
		assertTrue(textFileWriter instanceof TextFileWriter);
		textFileWriter.write("sample text");
	}

}
