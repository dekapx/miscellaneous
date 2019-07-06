package com.kapx.java.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversionUtil {
    public static final int MEGABYTE_MULTIPLIER = 1024;
    public static final long GIGABYTE_MULTIPLIER = 1024L * 1024L * 1024L;

    public static void main(String[] args) {
        final long bytes = 5927054869L; // 5.25 GB
        final int roundUpDecimals = 2;
        final double bytesGb = convertByteToGibibyteRoundUpDecimals(bytes, roundUpDecimals);
        System.out.println(bytes + " bytes equals to " + bytesGb + " GB...");

        final int bytesMb = convertByteToKilobyte(bytes);
        System.out.println(bytes + " bytes equals to " + bytesMb + " MB...");
    }

    public static int convertByteToKilobyte(long bytes) {
        final Long roundedValue = bytes / MEGABYTE_MULTIPLIER;
        return roundedValue.intValue();
    }

    public static double convertByteToGibibyteRoundUpDecimals(final long bytes, final int roundUpDecimals) {
        final double value = (double) bytes / (double) GIGABYTE_MULTIPLIER;
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(roundUpDecimals, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
