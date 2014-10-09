package com.kapx.java7.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

	static Callable<String> task = new Callable<String>() {

		@Override
		public String call() throws Exception {
			System.out.println("executing callable...");
			for (int i = 0; i < 5; i++) {
				System.out.print(" " + i);
				TimeUnit.SECONDS.sleep(2);
			}
			return "task completed";
		}
	};

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(task);
		try {
			System.out.println("Output: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
