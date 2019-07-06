package com.kapx.java.collection;

import java.util.HashMap;
import java.util.Map;

public class MapTraversal {
	public static void main(String[] args) {
		final Map<String, String> contact = new HashMap<>();
		contact.put("name", "Dekapx");
		contact.put("address", "Athlone, Ireland");
		contact.forEach((key, value) -> System.out.println(key + " - " + value));
	}
}
