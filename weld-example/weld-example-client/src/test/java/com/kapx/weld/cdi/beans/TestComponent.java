package com.kapx.weld.cdi.beans;

import javax.inject.Named;

@Named("test")
public class TestComponent implements EventInputHandler {

	@Override
	public void handleEvent() {
		System.out.println("TestComponent.handleEvent()");
	}

}
