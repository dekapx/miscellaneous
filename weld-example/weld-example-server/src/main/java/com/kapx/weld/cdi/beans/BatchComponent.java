package com.kapx.weld.cdi.beans;

import javax.inject.Named;

@Named("batch")
public class BatchComponent implements EventInputHandler {

	@Override
	public void handleEvent() {
		System.out.println("BatchComponent.handleEvent()");
	}

}
