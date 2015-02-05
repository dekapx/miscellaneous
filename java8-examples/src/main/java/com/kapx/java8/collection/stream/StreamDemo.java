package com.kapx.java8.collection.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
	public static void main(String[] args) {
		final List<String> elements = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			elements.add(String.valueOf(i + 1));
		}

		elements.stream().forEach((value) -> {
			System.out.print(value + " ");
		});
	}
}
