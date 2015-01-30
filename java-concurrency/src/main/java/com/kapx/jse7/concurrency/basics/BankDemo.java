package com.kapx.jse7.concurrency.basics;

public class BankDemo {
	public static void main(String[] args) {
		final BankDemo bankDemo = new BankDemo();
		try {
			bankDemo.performTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void performTransaction() {
		final double initialDeposite = 10000;
		final BankAccount bankAccount = new BankAccount(initialDeposite);

		final Runnable depositTask = new Depositor(bankAccount);
		final Thread depositorThread = new Thread(depositTask);
		depositorThread.start();

		final Runnable withdrawTask = new Withdrawer(bankAccount);
		final Thread withdrawerThread = new Thread(withdrawTask);
		withdrawerThread.start();

		try {
			depositorThread.join();
			withdrawerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Remaining balance amount is : " + bankAccount.getBalance());
	}
}
