package com.kapx.java7.collections.maps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectCache {

	private static final ObjectCache INSTANCE = new ObjectCache();

	private final Map<String, Object> cachedObjects = new ConcurrentHashMap<>();

	private ObjectCache() {
	}

	public static ObjectCache getInstance() {
		return INSTANCE;
	}

	public void put(final String key, final Object value) {
		if (key == null || key.isEmpty()) {
			throw new IllegalArgumentException("key must not be null or empty.");
		}
		if (value == null) {
			throw new IllegalArgumentException("value must not be null.");
		}
		cachedObjects.put(key.toUpperCase(), value);
	}

	public Object get(final String key) {
		if (key == null || key.isEmpty()) {
			throw new IllegalArgumentException("key must not be null or empty.");
		}

		if (cachedObjects.containsKey(key.toUpperCase())) {
			return cachedObjects.get(key.toUpperCase());
		}

		return null;
	}
}
