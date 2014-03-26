package com.kapx.java7.concurrency.collections;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueExample {

	private class PushObjects implements Callable<Void> {
		private BlockingQueue<DelayObject> queue = null;

		public PushObjects(final BlockingQueue<DelayObject> queue) {
			this.queue = queue;
		}

		@Override
		public Void call() throws Exception {
			for (int i = 0; i < 10; i++) {
				System.out.println(new Date() + " - add object to the queue");
				DelayObject objectIn = new DelayObject("test", 5);
				queue.put(objectIn);
			}
			return null;
		}
	}

	private class PollObjects implements Callable<Void> {
		private BlockingQueue<DelayObject> queue = null;

		public PollObjects(final BlockingQueue<DelayObject> queue) {
			this.queue = queue;
		}

		@Override
		public Void call() throws Exception {
			while (true) {
				DelayObject objectOut = queue.take();
				System.out.println(new Date() + " - Poll object from the queue -> " + objectOut);

				if (queue.isEmpty())
					break;
			}
			return null;
		}
	}

	public void execute() {
		final BlockingQueue<DelayObject> queue = new DelayQueue<>();

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new PushObjects(queue));
		executorService.submit(new PollObjects(queue));

		executorService.shutdown();
	}

	public static void main(String[] args) throws Exception {
		DelayQueueExample queueExample = new DelayQueueExample();
		queueExample.execute();
	}
}
