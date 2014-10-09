package com.kapx.java7.concurrency.atomic;

public class AtomicDemo {
	public static void main(String[] args) throws Exception {
		ProcessorTask task = new ProcessorTask();
		Thread t1 = new Thread(task, "T1");
		t1.start();

		Thread t2 = new Thread(task, "T2");
		t2.start();

		t1.join();
		t2.join();
		System.out.println("Processing count=" + task.getCount());
	}
}
