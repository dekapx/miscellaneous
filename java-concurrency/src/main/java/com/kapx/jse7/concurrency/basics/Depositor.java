package com.kapx.jse7.concurrency.basics;

import java.util.concurrent.TimeUnit;

public class Depositor implements Runnable {
	private BankAccount bankAccount;

	public Depositor(final BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		final double amount = 1000;
		for (int i = 0; i < 105; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("deposite 1000...");
			this.bankAccount.deposite(amount);
		}
	}

}
