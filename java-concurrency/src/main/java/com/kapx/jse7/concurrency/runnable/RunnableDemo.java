package com.kapx.jse7.concurrency.runnable;

public class RunnableDemo {
	private static Runnable runnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("Executing " + Thread.currentThread().getName());
			for (int i = 0; i < 5; i++) {
				System.out.println(i + 1);
			}
		}
	};

	public static void main(String[] args) {
	}
}
