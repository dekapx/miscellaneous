package com.kapx.weld.cdi.beans;

import com.kapx.weld.cdi.events.SampleEvent;

public interface EventInputHandler {

	void handleEvent(SampleEvent event);

}
