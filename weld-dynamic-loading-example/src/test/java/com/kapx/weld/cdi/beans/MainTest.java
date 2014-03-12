package com.kapx.weld.cdi.beans;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class MainTest {

	@Test
	public void testMain() {
		try {
			WeldContainer weld = new Weld().initialize();
			Main main = weld.instance().select(Main.class).get();
			main.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
