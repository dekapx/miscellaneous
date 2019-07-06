package com.kapx.java.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadExample {
	public static void main(String[] args) throws Exception {
		runnableNonLambda();
		runnableLambda();
	}

	private static void runnableNonLambda() throws Exception {
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.print((i + 1) + " ");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		new Thread(runnable).start();
	}

	private static void runnableLambda() throws Exception {
		final Runnable runnable = () -> {
			for (int i = 5; i < 10; i++) {
				System.out.print((i + 1) + " ");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}
}
