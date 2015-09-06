package com.kapx.jse.concurrency.callable;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class CountSumCallable implements Callable<Integer> {
	private int[] numbers;

	public CountSumCallable(final int[] numbers) {
		if (numbers == null || numbers.length <= 0) {
			throw new IllegalArgumentException("Numbers must not be null or blank");
		}
		// use copy to avoid the direct reference...
		this.numbers = Arrays.copyOf(numbers, numbers.length);
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		return sum;
	}

}
