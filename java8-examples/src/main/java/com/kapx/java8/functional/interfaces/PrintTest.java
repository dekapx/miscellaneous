package com.kapx.java8.functional.interfaces;

public class PrintTest {
	public static void main(String[] args) {
		Printable job = () -> System.out.println("Java SE-8 FunctionalInterface Demo");
		job.print();
	}
}
