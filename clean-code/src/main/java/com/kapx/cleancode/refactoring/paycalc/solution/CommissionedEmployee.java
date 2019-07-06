package com.kapx.cleancode.refactoring.paycalc.solution;

public class CommissionedEmployee implements Employee {
    @Override
    public Money calculatePay() {
        return new Money(100.50);
    }

    @Override
    public EmployeeType getType() {
        return EmployeeType.COMMISSIONED;
    }
}
