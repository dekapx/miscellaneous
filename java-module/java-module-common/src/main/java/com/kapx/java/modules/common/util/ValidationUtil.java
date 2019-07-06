package com.kapx.java.modules.common.util;

public class ValidationUtil {
    public static boolean isValidEmail(final String email) {
        return EmailValidator.isValidEmail(email);
    }
}
