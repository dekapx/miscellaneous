package com.kapx.jse.concurrency.join;

public class ThreadJoinExecutor {
	public static void main(String[] args) throws InterruptedException {
		System.out.print("Execution started...");

		final Runnable taskA = new TaskExecutorA();
		final Thread executorA = new Thread(taskA);
		executorA.start();
		executorA.join();

		final Runnable taskB = new TaskExecutorB();
		final Thread executorB = new Thread(taskB);
		executorB.start();
		executorB.join();

		final Runnable taskC = new TaskExecutorC();
		final Thread executorC = new Thread(taskC);
		executorC.start();
		executorC.join();

		System.out.println("\nExecution completed...");
	}
}
