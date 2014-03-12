package com.kapx.guava.preconditions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class PreconditionsExample {
	public static void main(String[] args) {
		PreconditionsExample example = new PreconditionsExample();
		example.sayHelloo("test");
	}

	private void checkPreconditions(String arg) {
		checkNotNull(arg, "Argument must not be null");
		checkArgument(!arg.trim().isEmpty(), "Argument must not be empty");
	}

	public void sayHelloo(String arg) {
		checkPreconditions(arg);

		System.out.println("Hello !!! " + arg);
	}
}
