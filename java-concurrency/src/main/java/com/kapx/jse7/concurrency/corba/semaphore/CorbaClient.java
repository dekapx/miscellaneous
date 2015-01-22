package com.kapx.jse7.concurrency.corba.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CorbaClient {
	private final Semaphore lock = new Semaphore(0);

	public void invokeCorbaObject() {
		try {
			lock.tryAcquire(1, TimeUnit.SECONDS);
			InventoryImpl inventoryImpl = new InventoryImpl(lock);

			CorbaObject corbaObject = new CorbaObject();
			int inventoryType = corbaObject.getInventoryType(inventoryImpl);
			System.out.println("inveotory type = " + inventoryType);
			System.out.println("xml file path = " + inventoryImpl.getXmlFilePath());

			System.out.println("after 1 sec... xml file path = " + inventoryImpl.getXmlFilePath());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CorbaClient client = new CorbaClient();
		client.invokeCorbaObject();
	}
}
