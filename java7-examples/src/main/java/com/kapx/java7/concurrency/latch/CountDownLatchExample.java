package com.kapx.java7.concurrency.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(1);

		Task taskOne = new Task("TaskOne", latch);

		new Thread(taskOne).start();

		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("All threads have started...");
	}
}
