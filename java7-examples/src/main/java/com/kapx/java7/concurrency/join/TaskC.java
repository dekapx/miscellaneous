package com.kapx.java7.concurrency.join;

import java.util.concurrent.TimeUnit;

class TaskC implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("\nStarting task C");
			for (int i = 0; i < 5; i++) {
				System.out.print("C ");
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (Exception e) {
			System.out.println("unable to execute TaskA");
		}
	}

}
