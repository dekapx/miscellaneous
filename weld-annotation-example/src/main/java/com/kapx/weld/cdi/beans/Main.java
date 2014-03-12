package com.kapx.weld.cdi.beans;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.kapx.weld.cdi.annotations.Batch;

public class Main {

	@Inject
	// @CollectionSplitter
	EventInputHandler collectionSplitter;

	@Inject
	@Batch
	EventInputHandler batch;

	public void start(@Observes ContainerInitialized event) {
	}

	public void test() {
		collectionSplitter.handleEvent();

		batch.handleEvent();
	}
}
