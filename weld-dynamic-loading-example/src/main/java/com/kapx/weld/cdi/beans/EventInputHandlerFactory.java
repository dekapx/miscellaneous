package com.kapx.weld.cdi.beans;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Set;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.kapx.weld.cdi.annotations.Preferred;

public class EventInputHandlerFactory implements Serializable {

	private static final long serialVersionUID = 8832767831642927735L;

	@Produces
	@Preferred
	public EventInputHandler getEventInputHandler(InjectionPoint injectionPoint) {
		Set<Annotation> annotations = injectionPoint.getAnnotated().getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Preferred) {
				Preferred preferred = (Preferred) annotation;
				String className = preferred.type();
				return loadClass(className);
			}
		}

		return null;

	}

	private EventInputHandler loadClass(String className) {
		EventInputHandler eventInputHandler = null;

		try {
			eventInputHandler = (EventInputHandler) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return eventInputHandler;
	}
}
