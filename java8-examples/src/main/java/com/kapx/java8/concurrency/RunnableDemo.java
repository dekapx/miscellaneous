package com.kapx.java8.concurrency;

public class RunnableDemo {
	public static void main(String[] args) {
		Runnable r1 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("running in a thread...");
			}
		};
		new Thread(r1).start();
	}
}
