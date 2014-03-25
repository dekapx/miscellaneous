package com.kapx.java7.concurrency.collections;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {
	public static void main(String[] args) throws Exception {
		final BlockingQueue<DelayObject> queue = new DelayQueue<>();
		System.out.println("Adding object in the queue @ " + new Date());
		DelayObject objectIn1 = new DelayObject("test", 15);
		queue.put(objectIn1);
		System.out.println("add 1st element" + new Date());

		DelayObject objectIn2 = new DelayObject("test", 15);
		queue.put(objectIn2);
		System.out.println("add 2nd element" + new Date());

		queue.take();
		System.out.println("Object out... @ " + new Date());
		queue.take();
		System.out.println("Object out... @ " + new Date());
	}
}
