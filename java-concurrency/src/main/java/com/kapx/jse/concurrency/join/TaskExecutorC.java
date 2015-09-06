package com.kapx.jse.concurrency.join;

import java.util.concurrent.TimeUnit;

public class TaskExecutorC implements Runnable {

	@Override
	public void run() {
		System.out.println("\nExecuting TaskExecutor C...");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.print("C ");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
