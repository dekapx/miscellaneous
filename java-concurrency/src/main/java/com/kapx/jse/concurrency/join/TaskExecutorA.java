package com.kapx.jse.concurrency.join;

import java.util.concurrent.TimeUnit;

public class TaskExecutorA implements Runnable {

	@Override
	public void run() {
		System.out.println("\nExecuting TaskExecutor A...");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.print("A ");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
