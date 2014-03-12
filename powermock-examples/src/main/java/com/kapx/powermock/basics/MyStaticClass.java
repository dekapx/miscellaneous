package com.kapx.powermock.basics;

public class MyStaticClass {

	public static boolean isValidString(final String arg) {
		if (arg == null || arg.isEmpty()) {
			return false;
		}

		return true;
	}
}
