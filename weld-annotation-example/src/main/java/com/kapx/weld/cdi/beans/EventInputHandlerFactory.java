package com.kapx.weld.cdi.beans;

import java.io.Serializable;

import javax.enterprise.inject.Produces;

import com.kapx.weld.cdi.annotations.Batch;
import com.kapx.weld.cdi.annotations.CollectionSplitter;

public class EventInputHandlerFactory implements Serializable {

	private static final long serialVersionUID = 8832767831642927735L;

	@Produces
	@CollectionSplitter
	public EventInputHandler getCollectionSplitterComponent() {
		EventInputHandler eventInputHandler = new CollectionSplitterComponent();
		return eventInputHandler;
	}

	@Produces
	@Batch
	public EventInputHandler getBatchComponent() {
		EventInputHandler eventInputHandler = new BatchComponent();
		return eventInputHandler;
	}
}
