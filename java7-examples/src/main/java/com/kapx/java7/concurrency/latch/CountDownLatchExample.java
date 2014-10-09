package com.kapx.java7.concurrency.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);

		Task taskOne = new Task("TaskOne", latch);
		Task taskTwo = new Task("TaskTwo", latch);
		Task taskThree = new Task("TaskThree", latch);

		new Thread(taskOne).start();
		new Thread(taskTwo).start();
		new Thread(taskThree).start();

		try {
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("All threads have started...");
	}
}
