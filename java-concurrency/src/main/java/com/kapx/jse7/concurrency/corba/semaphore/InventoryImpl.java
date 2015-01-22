package com.kapx.jse7.concurrency.corba.semaphore;

import java.util.concurrent.Semaphore;

public class InventoryImpl {
	private String xmlFilePath;
	private Semaphore lock;

	public InventoryImpl(Semaphore lock) {
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
		lock.release();
		System.out.println("releasing the lock...");
	}
}
