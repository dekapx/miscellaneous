package com.kapx.cleancode.refactoring.paycalc.solution;

public class SalariedEmployee implements Employee {
    @Override
    public Money calculatePay() {
        return new Money(1250.00);
    }

    @Override
    public EmployeeType getType() {
        return EmployeeType.SALARIED;
    }
}
