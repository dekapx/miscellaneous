package com.kapx.weld.cdi.utils;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import com.kapx.weld.cdi.beans.BatchComponent;
import com.kapx.weld.cdi.beans.CollectionSplitterComponent;
import com.kapx.weld.cdi.beans.EventInputHandler;
import com.kapx.weld.cdi.beans.TestComponent;

public class BeanUtilsTest {

	@Test
	public void testGetBeanByName() {
		try {
			WeldContainer weld = new Weld().initialize();
			BeanUtils beanUtils = weld.instance().select(BeanUtils.class).get();

			EventInputHandler handler = null;

			handler = beanUtils.getBeanByName("splitter");
			assertTrue(handler instanceof CollectionSplitterComponent);
			handler.handleEvent();

			handler = beanUtils.getBeanByName("batch");
			assertTrue(handler instanceof BatchComponent);
			handler.handleEvent();

			handler = beanUtils.getBeanByName("test");
			assertTrue(handler instanceof TestComponent);
			handler.handleEvent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
