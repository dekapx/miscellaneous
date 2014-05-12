package com.kapx.java7.concurrency.join;

import java.util.concurrent.TimeUnit;

class TaskA implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("\nStarting task A");
			for (int i = 0; i < 5; i++) {
				System.out.print("A ");
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (Exception e) {
			System.out.println("unable to execute TaskA");
		}
	}

}
