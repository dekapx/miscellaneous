package com.kapx.weld.cdi.beans;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

public class EventInputHandlerFactory implements Serializable {

	private static final long serialVersionUID = 8832767831642927735L;

	@Produces
	public EventInputHandler getEventInputHandler(InjectionPoint injectionPoint) {
		Annotated annotated = injectionPoint.getAnnotated();
		EventInputHandler eventInputHandler = new CollectionSplitterComponent();
		return eventInputHandler;
	}
}
