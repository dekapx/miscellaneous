package com.kapx.jse.concurrency.join;

import java.util.concurrent.TimeUnit;

public class TaskExecutorB implements Runnable {

	@Override
	public void run() {
		System.out.println("\nExecuting TaskExecutor B...");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.print("B ");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
