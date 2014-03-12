package com.kapx.jboss.web.manager;

import org.jboss.weld.environment.se.Weld;

public class CdiJseInstanceManager extends AbstractCdiInstanceManager {
	private static final CdiJseInstanceManager INSTANCE = new CdiJseInstanceManager();

	private CdiJseInstanceManager() {
	}

	public static CdiJseInstanceManager getInstance() {
		return INSTANCE;
	}

	public void start() {
		weldContainer = new Weld().initialize();
	}

	public void stop() {
		weldContainer = null;
	}

	public <T> T getBeanInstanceByClass(final Class<T> clazz) {
		return super.getBeanInstanceByClass(clazz);
	}

}
