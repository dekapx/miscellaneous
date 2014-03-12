package com.kapx.weld.cdi.beans;

import com.kapx.weld.cdi.events.SampleEvent;

public class CollectionSplitterComponent implements EventInputHandler {

	@Override
	public void handleEvent(SampleEvent event) {
		System.out.println("CollectionSplitterComponent.handleEvent(SampleEvent event)");
	}

}
