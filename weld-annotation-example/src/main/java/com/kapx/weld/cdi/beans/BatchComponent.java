package com.kapx.weld.cdi.beans;

public class BatchComponent implements EventInputHandler {

	@Override
	public void handleEvent() {
		System.out.println("BatchComponent.handleEvent()");
	}

}
