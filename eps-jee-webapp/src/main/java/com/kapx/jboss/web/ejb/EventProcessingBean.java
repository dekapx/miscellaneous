package com.kapx.jboss.web.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(EventProcessingLocal.class)
public class EventProcessingBean implements EventProcessingLocal {

	@Override
	public void processEvent(final Object event) {
		System.out.println("processing event by EventProcessingBean " + event);
	}

}
