package com.kapx.java7.concurrency.join;

import java.util.concurrent.TimeUnit;

public class ThreadJoinTest {
	private Runnable runnable = new Runnable() {

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.print("[ " + Thread.currentThread().getName() + "-" + i + " ]");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public void test() throws Exception {
		final Thread x = new Thread(runnable);
		x.setName("X");
		x.start();

		final Thread y = new Thread(runnable);
		y.setName("Y");
		y.start();

		y.join();

		for (int i = 1; i <= 5; i++) {
			System.out.print("(" + i + ")");
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void main(String[] args) {
		try {
			new ThreadJoinTest().test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
