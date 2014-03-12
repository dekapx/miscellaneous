package com.kapx.weld.cdi.events;

public class SampleEvent {

	private String type;

	public SampleEvent(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
