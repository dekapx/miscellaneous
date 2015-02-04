package com.kapx.java8.annotation.repeateable;

/**
 * This example demonstrate the use of repeatable annotations
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
