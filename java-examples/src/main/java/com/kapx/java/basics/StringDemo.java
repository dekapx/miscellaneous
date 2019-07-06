package com.kapx.java.basics;

public class StringDemo {
	public static void main(String[] args) {
		final String str = "dekapx";
		str.chars().forEach(chr -> System.out.println(chr));
	}
}
