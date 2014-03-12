package com.kapx.weld.cdi.beans;

import javax.inject.Named;

@Named("splitter")
public class CollectionSplitterComponent implements EventInputHandler {

	@Override
	public void handleEvent() {
		System.out.println("CollectionSplitterComponent.handleEvent()");
	}

}
