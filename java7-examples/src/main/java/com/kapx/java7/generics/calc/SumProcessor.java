package com.kapx.java7.generics.calc;

/**
 * Inteface representing sum operation processing.
 * 
 * @author ekalkur
 * 
 * @param <R>
 *            Generic type represent request
 * @param <S>
 *            Generic type represent response
 */
public interface SumProcessor<R, S> {
	S sum(R request);
}
