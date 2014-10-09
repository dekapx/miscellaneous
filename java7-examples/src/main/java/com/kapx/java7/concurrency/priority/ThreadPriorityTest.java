package com.kapx.java7.concurrency.priority;

import java.util.concurrent.TimeUnit;

public class ThreadPriorityTest {
	private Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.print("[ "+ Thread.currentThread().getName() + "-" + i + " ]");
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public void test() {
		Thread x = new Thread(runnable);
		x.setName("X");
		x.setPriority(Thread.MAX_PRIORITY);
		x.start();
		
		Thread y = new Thread(runnable);
		y.setName("Y");
		y.setPriority(Thread.MIN_PRIORITY);
		y.start();
	}
	
	public static void main(String[] args) {
		new ThreadPriorityTest().test();
	}
}
