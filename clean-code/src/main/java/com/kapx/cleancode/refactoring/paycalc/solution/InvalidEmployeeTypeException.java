package com.kapx.cleancode.refactoring.paycalc.solution;

public class InvalidEmployeeTypeException extends RuntimeException {
    public InvalidEmployeeTypeException(final Exception e) {
        super(e);
    }
}
