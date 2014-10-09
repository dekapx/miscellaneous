package com.kapx.java7.generics.calc;

public class SumProcessorImpl<R, S> implements SumProcessor<SumRequest, SumResponse> {

	@Override
	public SumResponse sum(SumRequest request) {
		System.out.println(Thread.currentThread().getName() + " processing request .... " + request);
		SumResponse resp = new SumResponse();
		resp.setRequestId(request.getId());
		resp.setResult(request.getOperand1() + request.getOperand2());
		return resp;
	}
}
