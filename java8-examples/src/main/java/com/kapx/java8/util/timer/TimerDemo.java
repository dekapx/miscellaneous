package com.kapx.java8.util.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	private static TimerTask task = new TimerTask() {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}

	};

	public static void main(String[] args) {
		final Timer timer = new Timer("Timer");
		final long delay = 1000L;
		final long period = 1000L;
		timer.scheduleAtFixedRate(task, delay, period);
	}
}
