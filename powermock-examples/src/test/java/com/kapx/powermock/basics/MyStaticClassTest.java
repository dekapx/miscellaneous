package com.kapx.powermock.basics;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MyStaticClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@PrepareForTest(MyStaticClass.class)
	public void testIsValidStringForNull() {
		mockStatic(MyStaticClass.class);
		when(MyStaticClass.isValidString(null)).thenReturn(Boolean.FALSE);
		assertFalse(MyStaticClass.isValidString(null));

		when(MyStaticClass.isValidString(Mockito.anyString())).thenReturn(Boolean.TRUE);
		assertTrue(MyStaticClass.isValidString("Kapx"));
	}
}
