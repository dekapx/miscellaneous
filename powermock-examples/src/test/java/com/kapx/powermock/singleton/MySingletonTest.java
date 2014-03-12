package com.kapx.powermock.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.kapx.powermock.singleton.MySingleton;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MySingleton.class })
public class MySingletonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSingletonObject() {
		MySingleton mockInstance = mock(MySingleton.class);
		Whitebox.setInternalState(MySingleton.class, "INSTANCE", mockInstance);

		when(mockInstance.sayHello("Kapx")).thenReturn("Hello Kapx");

		String actual = mockInstance.sayHello("Kapx");
		assertNotNull(actual);
		assertEquals("Hello Kapx", actual);
	}

}
