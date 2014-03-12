package com.kapx.jboss.web.manager;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CdiJeeInstanceManager extends AbstractCdiInstanceManager {

	@Override
	public <T> T getBeanInstanceByClass(final Class<T> clazz) {
		return super.getBeanInstanceByClass(clazz);
	}

}
