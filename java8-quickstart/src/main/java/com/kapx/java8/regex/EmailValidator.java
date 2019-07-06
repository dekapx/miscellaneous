package com.kapx.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        final String regex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b";
        final Pattern pattern = Pattern.compile(regex);
        final String email = "xkapil@gmail.com";
        final Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            System.out.println("MATCH: " + matcher.group());
        } else {
            System.out.println("NO MATCH");
        }
    }
}
