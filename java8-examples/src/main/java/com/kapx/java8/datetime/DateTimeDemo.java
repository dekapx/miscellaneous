package com.kapx.java8.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
	public static void main(String[] args) {
		// display current date
		displayCurrentDate();

		// display current time
		displayCurrentTime();

		// parse a date from string
		parseDateFromString();

		// add 5 days to current date
		addDaysToDate();
	}

	private static void displayCurrentDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("Current date: " + localDate);
	}

	private static void displayCurrentTime() {
		LocalTime localTime = LocalTime.now();
		System.out.println("Current time: " + localTime);
	}

	private static void parseDateFromString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse("12/24/2014", formatter);
		System.out.println("Date: " + date);
	}

	private static void addDaysToDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("Before: " + localDate);
		LocalDate localDatePlus5Days = localDate.plusDays(5);
		System.out.println("After: " + localDatePlus5Days);
	}
}
