package com.kapx.weld.cdi.util;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileWriterUtilTest {
	private FileWriterUtil fileWriterUtil;

	@Before
	public void setUp() throws Exception {
		final WeldContainer weld = new Weld().initialize();
		fileWriterUtil = weld.instance().select(FileWriterUtil.class).get();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWriteToFile() {
		fileWriterUtil.writeToFile("sample text");
	}

}
