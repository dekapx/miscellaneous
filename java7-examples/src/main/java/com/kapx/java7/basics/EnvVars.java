package com.kapx.java7.basics;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EnvVars {
	public static void main(String[] args) {
		final Map<String, String> map = System.getenv();
		final Set<Entry<String, String>> set = map.entrySet();

		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		System.out.println();
	}
}
