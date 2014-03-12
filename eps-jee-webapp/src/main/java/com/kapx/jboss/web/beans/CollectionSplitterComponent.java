package com.kapx.jboss.web.beans;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import com.kapx.jboss.web.ejb.EventProcessingLocal;

@Named("splitter")
public class CollectionSplitterComponent implements EventInputHandler {

	@EJB
	private EventProcessingLocal eventProcessingEJB;

	@Override
	public void onEvent(@Observes final Object event) {
		sendEventToSubscribers(event);
	}

	private void sendEventToSubscribers(final Object event) {
		eventProcessingEJB.processEvent(event);
	}

}
