package com.kapx.jse.concurrency.runnable;

public class SimpleTaskExecutor {
	public static void main(String[] args) {
		System.out.println("SimpleTaskExecutor starts...");
		final Runnable simpleTask = new SimpleTask();
		new Thread(simpleTask, "SimpleTask").start();
		System.out.println("SimpleTaskExecutor ends...");
	}
}
