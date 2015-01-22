package com.kapx.jse7.concurrency.corba.lock;

import java.util.concurrent.locks.Lock;

public class InventoryImpl {
	private String xmlFilePath;

	private Lock lock;

	public InventoryImpl(Lock lock) {
		this.lock = lock;
	}

	public String getXmlFilePath() {
		return xmlFilePath;
	}

	private void setXmlFilePath(String xmlFilePath) {
		this.xmlFilePath = xmlFilePath;
	}

	public void ready(String xmlFilePath) {
		System.out.println("this will set the xml path after a while...");
		System.out.println("wait is over! setting xml file path...");

		setXmlFilePath(xmlFilePath);
		System.out.println("releasing the lock...");
		try {
			lock.unlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
