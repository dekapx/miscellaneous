package com.kapx.weld.cdi.beans;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.kapx.weld.cdi.annotations.Preferred;

public class Main {

	@Inject
	@Preferred(type = "com.kapx.weld.cdi.beans.CollectionSplitterComponent")
	EventInputHandler collectionSplitter;

	@Inject
	@Preferred(type = "com.kapx.weld.cdi.beans.BatchComponent")
	EventInputHandler batchComponent;

	public void start(@Observes ContainerInitialized event) {
	}

	public void test() {
		collectionSplitter.handleEvent();

		batchComponent.handleEvent();
	}
}
