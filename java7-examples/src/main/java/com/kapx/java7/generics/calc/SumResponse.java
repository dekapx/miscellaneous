package com.kapx.java7.generics.calc;

public class SumResponse {
	private String requestId;
	private int result;

	protected String getRequestId() {
		return requestId;
	}

	protected void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	protected int getResult() {
		return result;
	}

	protected void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "SumResponse [requestId=" + requestId + ", result=" + result + "]";
	}
}
