package com.kapx.jse7.concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TaskExecuter {
	public Integer execute(final int[] numbers) throws Exception {

		final Callable<Integer> callable = new CountSumCallable(numbers);
		final FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		final ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.submit(futureTask);
		try {
			// fail if unable to get the response in 1 second
			return futureTask.get(1, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException e) {
			throw new Exception(e);
		}
	}
}
