package com.kapx.guava.collections;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

public class ListExample {
	public static void main(String[] args) {
		final String[] elements = { "A", "B", "C", "D", "E" };
		List<String> list = Lists.newArrayList();
		list.addAll(Arrays.asList(elements));
	}
}
