package com.kapx.java7.util.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 2014-04-25 18:22:24
public class DateUtil {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:SS";

	public static void main(String[] args) {
		System.out.println(formatDate(new Date()));
	}

	public static String formatDate(final Date date) {
		if (date == null) {
			throw new IllegalArgumentException("date must not be null");
		}

		final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		return dateFormat.format(date);
	}
}
