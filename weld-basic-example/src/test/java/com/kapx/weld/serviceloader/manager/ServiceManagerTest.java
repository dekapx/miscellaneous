package com.kapx.weld.serviceloader.manager;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.kapx.weld.cdi.beans.MessageSender;
import com.kapx.weld.cdi.beans.SmsMessageSender;

public class ServiceManagerTest {
	private ServiceManager serviceManager;

	@Before
	public void setup() {
		serviceManager = ServiceManager.getInstance();
	}

	@Test
	public void test() {
		serviceManager = ServiceManager.getInstance();

		MessageSender messageSender = serviceManager.getService(SmsMessageSender.class);
		Assert.assertNotNull(messageSender);
		Assert.assertTrue(messageSender instanceof SmsMessageSender);
	}
}
