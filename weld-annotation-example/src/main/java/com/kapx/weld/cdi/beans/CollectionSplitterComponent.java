package com.kapx.weld.cdi.beans;

public class CollectionSplitterComponent implements EventInputHandler {

	@Override
	public void handleEvent() {
		System.out.println("CollectionSplitterComponent.handleEvent()");
	}

}
