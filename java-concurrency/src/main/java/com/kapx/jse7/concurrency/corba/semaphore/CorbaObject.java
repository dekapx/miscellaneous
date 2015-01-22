package com.kapx.jse7.concurrency.corba.semaphore;


public class CorbaObject {

	public int getInventoryType(InventoryImpl inventoryImpl) {
		System.out.println("call to get inventory type...");
		populateXmlPath(inventoryImpl);
		return 1;
	}

	private void populateXmlPath(InventoryImpl inventoryImpl) {
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				inventoryImpl.ready("var/opt/ericsson/test-data.xml");
			}
		};

		new Thread(runnable).start();
	}
}
