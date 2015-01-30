package com.kapx.jse7.concurrency.basics;

public class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposite(double amount) {
		this.balance = (this.balance + amount);
	}

	public void withdraw(double amount) {
		this.balance = (this.balance - amount);
	}
}
