package com.kapx.java7.concurrency.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private String name;
	private CountDownLatch latch;

	public Task(final String name, final CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(name + " is started...");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.print(i + " ");
				TimeUnit.SECONDS.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		latch.countDown();
	}

}
