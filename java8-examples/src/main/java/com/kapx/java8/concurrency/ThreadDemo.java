package com.kapx.java8.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
	public static void main(String[] args) {
		final Thread thread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.print((i + 1) + " ");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();
	}
}
