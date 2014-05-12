package com.kapx.java7.generics.calc;

import java.util.UUID;

public class SumRequest {
	private String id = UUID.randomUUID().toString();
	private int operand1;
	private int operand2;

	protected int getOperand1() {
		return operand1;
	}

	protected void setOperand1(int operand1) {
		this.operand1 = operand1;
	}

	protected int getOperand2() {
		return operand2;
	}

	protected void setOperand2(int operand2) {
		this.operand2 = operand2;
	}

	protected String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "SumRequest [id=" + id + ", operand1=" + operand1 + ", operand2=" + operand2 + "]";
	}
}
