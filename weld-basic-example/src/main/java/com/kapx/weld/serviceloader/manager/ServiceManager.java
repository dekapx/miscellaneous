package com.kapx.weld.serviceloader.manager;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceManager {
	private static final ServiceManager instance = new ServiceManager();

	private ServiceManager() {
	}

	public static ServiceManager getInstance() {
		return instance;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> T getService(final Class<T> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Unable to find implementation for null class");
		}

		ServiceLoader<T> serviceLoader = ServiceLoader.load(clazz);
		final Iterator iter = serviceLoader.iterator();
		if (iter == null) {
			throw new IllegalStateException("Was not able to find any implementation for [" + clazz + "]. Please check your packaging!");
		}

		Object impl = null;
		while (iter.hasNext()) {
			impl = iter.next();
		}
		if (impl == null) {
			throw new IllegalStateException("Was not able to find any implementation for [" + clazz + "]. Please check your packaging!");
		}

		return (T) impl;
	}
}
