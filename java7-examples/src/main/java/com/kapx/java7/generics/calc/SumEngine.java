package com.kapx.java7.generics.calc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class SumEngine {
	private final AtomicInteger requestsCount = new AtomicInteger();

	ExecutorService executionService = null;

	// executes requests to sum
	public void execute(SumRequest... request) {
		executionService = Executors.newFixedThreadPool(5); // create a thread pool
		List<Callable<SumResponse>> tasks = createExecuteTasks(request);
		List<Future<SumResponse>> results = execute(tasks);
		for (Future<SumResponse> result : results) {

			try {
				System.out.println(Thread.currentThread().getName() + ": Response = " + result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		// initiates an orderly shutdown of thread pool
		executionService.shutdown();
	}

	// create tasks
	private List<Callable<SumResponse>> createExecuteTasks(SumRequest[] requests) {
		List<Callable<SumResponse>> tasks = new LinkedList<Callable<SumResponse>>();
		executingRequests(requests.length);
		for (SumRequest req : requests) {
			Callable<SumResponse> task = createTask(req);
			tasks.add(task);
		}

		return tasks;
	}

	// increment the requests counter
	private void executingRequests(int count) {
		requestsCount.addAndGet(count);
	}

	// creates callable (i.e executable or runnable tasks)
	private Callable<SumResponse> createTask(final SumRequest request) {
		// anonymous implementation of Callable.
		// Pre Java 8's way of creating closures
		Callable<SumResponse> task = new Callable<SumResponse>() {

			@Override
			public SumResponse call() throws Exception {
				System.out.println(Thread.currentThread().getName() + ": Request = " + request);
				SumProcessor<SumRequest, SumResponse> processor = new SumProcessorImpl<>();
				SumResponse result = processor.sum(request);
				return result;
			}

		};

		return task;
	}

	// executes the tasks
	private <T> List<Future<T>> execute(List<Callable<T>> tasks) {

		List<Future<T>> result = null;
		try {
			// invokes the sum(sumRequest) method by executing the closure call() inside createTask
			result = executionService.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return result;

	}

	public int getRequestsCount() {
		return requestsCount.get();
	}
}
