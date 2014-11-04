package com.kapx.java8.concurrency;

public class RunnableDemo {
	public static void main(String[] args) {
		final RunnableDemo demo = new RunnableDemo();
		demo.runnableJava8Style();
		demo.runnableJava7Style();
	}

	public void runnableJava8Style() {
		Runnable runnable = () -> {
			System.out.println("Java8 - running in a thread...");
			for (int i = 0; i < 5; i++) {
				System.out.print("X ");
			}
		};

		new Thread(runnable).start();
	}

	public void runnableJava7Style() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Java7 - running in a thread...");
				for (int i = 0; i < 5; i++) {
					System.out.print("Y ");
				}
			}
		};

		new Thread(runnable).start();
	}
}
