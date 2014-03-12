package com.kapx.jboss.web.manager;

import javax.inject.Inject;

import org.jboss.weld.environment.se.WeldContainer;

public abstract class AbstractCdiInstanceManager {

	@Inject
	protected WeldContainer weldContainer;

	protected <T> T getBeanInstanceByClass(final Class<T> clazz) {
		return weldContainer.instance().select(clazz).get();
	}
}
