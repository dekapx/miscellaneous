package com.kapx.java8.annotation.repeateable;

/**
 * This example demonstrate the use of repeatable annotations. Repeating annotations are a handy new
 * feature of Java 8, as they allow you to assign multiple versions of an annotation to a single
 * field, method, or class.
 * 
 * @author KAPIL
 *
 */
public class User {
	@Role(name = "AUTHOR")
	@Role(name = "REVIEWER")
	public void performTask() {
		System.out.println("perform some task...");
	}
}
