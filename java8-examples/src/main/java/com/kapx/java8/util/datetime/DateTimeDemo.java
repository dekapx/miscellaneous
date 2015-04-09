package com.kapx.java8.util.datetime;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeDemo {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();

		System.out.println(localDate);
		System.out.println(localTime);
	}
}
