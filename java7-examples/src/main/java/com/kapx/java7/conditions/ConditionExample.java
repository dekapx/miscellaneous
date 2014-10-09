package com.kapx.java7.conditions;

public class ConditionExample {
	public static void main(String[] args) {
		int i = 1;

		switch (i) {
		case -1:
			System.out.println("negative");
			break;
		case 0:
			System.out.println("equal");
			break;
		case 1:
			System.out.println("greater");
			break;
		default:
			break;
		}
	}
}
