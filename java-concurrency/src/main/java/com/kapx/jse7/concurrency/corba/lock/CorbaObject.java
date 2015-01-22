package com.kapx.jse7.concurrency.corba.lock;

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
				for (int i = 0; i < 100000; i++) {
				}

				inventoryImpl.ready("var/opt/ericsson/test-data.xml");
			}
		};

		new Thread(runnable).start();
	}
}
