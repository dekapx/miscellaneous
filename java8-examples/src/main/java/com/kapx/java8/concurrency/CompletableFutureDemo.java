package com.kapx.java8.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			return "Test";
		});

		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
