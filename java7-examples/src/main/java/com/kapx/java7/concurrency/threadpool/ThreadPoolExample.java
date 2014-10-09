package com.kapx.java7.concurrency.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CallableTask implements Callable<Void> {

	@Override
	public Void call() throws Exception {
		System.out.print(Thread.currentThread().getId() + " ");
		TimeUnit.SECONDS.sleep(1);

		return null;
	}

}

public class ThreadPoolExample {
	public static void main(String[] args) {
		final ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			executorService.submit(new CallableTask());
		}

		executorService.shutdown();
	}
}
