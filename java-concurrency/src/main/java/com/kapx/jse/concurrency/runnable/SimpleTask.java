package com.kapx.jse.concurrency.runnable;

import java.util.concurrent.TimeUnit;

public class SimpleTask implements Runnable {

	@Override
	public void run() {
		System.out.println("Executing " + Thread.currentThread().getName());
		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + " ");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
