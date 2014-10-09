package com.kapx.java7.concurrency.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeoutTaskExample {
	public static void main(String[] args) {
		try {
			FutureTask<Void> timeoutTask = new FutureTask<Void>(new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					for (int i = 0; i < 7; i++) {
						System.out.print(i + " ");
						TimeUnit.SECONDS.sleep(1);
					}
					
					return null;
				}
			});
			new Thread(timeoutTask).start();
			timeoutTask.get(5L, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}
	}
}
