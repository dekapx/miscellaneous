package com.kapx.java7.concurrency.join;

public class ThreadJoinTest {
	public static void main(String[] args) throws Exception {
		Runnable taskA = new TaskA();
		Thread taskAExecutor = new Thread(taskA);
		taskAExecutor.start();
		taskAExecutor.join();

		Runnable taskB = new TaskB();
		Thread taskBExecutor = new Thread(taskB);
		taskBExecutor.start();
		taskBExecutor.join();

		Runnable taskC = new TaskC();
		Thread taskCExecutor = new Thread(taskC);
		taskCExecutor.start();
		taskCExecutor.join();

		System.out.println("\nAll tasks completed...");
	}
}
