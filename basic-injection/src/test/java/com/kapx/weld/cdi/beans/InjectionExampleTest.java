package com.kapx.weld.cdi.beans;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Before;
import org.junit.Test;

import com.kapx.weld.cdi.beans.Application;

public class InjectionExampleTest {
	private WeldContainer weldContainer;

	@Before
	public void setUp() {
		weldContainer = new Weld().initialize();
	}

	@Test
	public void testInject() {
		Application application = weldContainer.instance().select(Application.class).get();
		application.execute();
	}
}
