package com.kapx.cleancode.refactoring.paycalc.solution;

public class PayCalculator {
    public Money calculatePay(Employee employee) throws InvalidEmployeeTypeException {
        return employee.calculatePay();
    }
}
