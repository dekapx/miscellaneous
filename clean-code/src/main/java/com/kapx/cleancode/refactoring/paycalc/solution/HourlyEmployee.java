package com.kapx.cleancode.refactoring.paycalc.solution;

public class HourlyEmployee implements Employee {
    @Override
    public Money calculatePay() {
        return new Money(25.75);
    }

    @Override
    public EmployeeType getType() {
        return EmployeeType.HOURLY;
    }
}
