package com.kapx.java7.concurrency.scheduling;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class ScheduledExecutorExample {
	private static final long INITIAL_DELAY = 5;
	private static final long PERIOD = 10;
	private static final long DURATION_IN_SECONDS = 60;

	private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public static void main(String[] args) {
		System.out.println(new Date() + " - Start beep for 60 seconds...");
		startBeep();
	}

	@SuppressWarnings("rawtypes")
	public static void startBeep() {
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println(new Date() + " - beep");
			}
		};

		final ScheduledFuture beeperHandle = scheduler.scheduleAtFixedRate(beeper, INITIAL_DELAY, PERIOD, SECONDS);

		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			}
		}, DURATION_IN_SECONDS, SECONDS);
	}
}
