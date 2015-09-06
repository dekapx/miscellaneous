package com.kapx.jse.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BasicCallableDemo {
	private Callable<Boolean> callable = new Callable<Boolean>() {

		@Override
		public Boolean call() throws Exception {
			System.out.println("Executing Callable...");
			for (int i = 0; i < 5; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.print((i + 1) + " ");
			}
			return Boolean.TRUE;
		}
	};

	public void executeCallable() {
		final ExecutorService executorService = Executors.newFixedThreadPool(1);

		try {
			final Future<Boolean> future = executorService.submit(callable);
			System.out.println("Callable output: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

		System.out.println("Callable execution completed...");
	}

	public static void main(String[] args) {
		final BasicCallableDemo demo = new BasicCallableDemo();
		demo.executeCallable();
	}
}
