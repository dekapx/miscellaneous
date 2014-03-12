package com.kapx.weld.cdi.events;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class EventGenerator {

	@Inject
	private Event<SampleEvent> events;

	public void generateEvents() {
		for (int i = 0; i < 5; i++) {
			events.fire(new SampleEvent("Event" + i));
		}
	}
}
