package com.kapx.jse7.concurrency.corba.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CorbaClient {
	private final Lock lock = new ReentrantLock();

	public void invokeCorbaObject() {

		try {
			InventoryImpl inventoryImpl = new InventoryImpl(lock);

			CorbaObject corbaObject = new CorbaObject();
			lock.lock();
			int inventoryType = corbaObject.getInventoryType(inventoryImpl);
			System.out.println("inveotory type = " + inventoryType);
			System.out.println("xml file path = " + inventoryImpl.getXmlFilePath());

			System.out.println("after 1 sec... xml file path = " + inventoryImpl.getXmlFilePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CorbaClient client = new CorbaClient();
		client.invokeCorbaObject();
	}
}
