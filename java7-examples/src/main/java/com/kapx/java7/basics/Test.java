package com.kapx.java7.basics;

public class Test {
	public static void main(String[] args) {
        final String cdiEnabled = System.getProperty("cdi.enabled");
        if (cdiEnabled != null && !cdiEnabled.isEmpty()) {
            if ("true".equalsIgnoreCase(cdiEnabled)) {
            	System.out.println("start");
            }
        }
	}
}
