package com.kapx.java7.collections.maps;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class ObjectCacheTest {
	private ObjectCache objectCache;

	@Before
	public void setUp() throws Exception {
		objectCache = ObjectCache.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		objectCache = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPutForNullKey() {
		objectCache.put("", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPutForNullValue() {
		objectCache.put("test", null);
	}

	@Test
	public void testPut() {
		objectCache.put("name", "KAPX");
		final Map<String, Object> cachedObjects = Whitebox.getInternalState(objectCache, "cachedObjects");
		assertEquals(1, cachedObjects.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetForNull() {
		objectCache.get(null);
	}

	@Test
	public void testGetValidKey() {
		objectCache.put("name", "KAPX");
		assertEquals("KAPX", (String) objectCache.get("name"));
	}

	@Test
	public void testGetInValidKey() {
		assertEquals(null, objectCache.get("age"));
	}
}
