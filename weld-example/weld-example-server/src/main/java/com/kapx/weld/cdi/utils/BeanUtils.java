package com.kapx.weld.cdi.utils;

import java.lang.annotation.Annotation;
import java.util.Iterator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import com.kapx.weld.cdi.beans.EventInputHandler;

@ApplicationScoped
public class BeanUtils {

	@Inject
	@Any
	private Instance<EventInputHandler> services;

	public EventInputHandler getBeanByName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("bean name must not be null");
		}

		Iterator<EventInputHandler> iterator = services.iterator();
		while (iterator.hasNext()) {
			EventInputHandler eventInputHandler = iterator.next();
			Annotation[] annotations = eventInputHandler.getClass().getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof Named) {
					Named named = (Named) annotation;
					if (name.equals(named.value())) {
						return eventInputHandler;
					}
				}
			}
		}

		return null;
	}
}
