package com.kapx.java7.sorter;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.comparators.ComparatorChain;

/**
 * Generic sorter utility that performs ascending and descending sorting on multiple attributes of a Java POJO.
 * 
 * @author Kapil Kumar
 * @Version 1.0
 */
public class MultiAttributeSorter {

	private static final int EQUAL = 0;
	private static final int LESS_THAN = -1;
	private static final int GREATER_THAN = 1;

	private static final String GET_TAG = "get";

	private MultiAttributeSorter() {
	}

	/**
	 * Perform sorting on collection of objects.
	 * 
	 * @param objects
	 *            collection of objects to be sorted
	 * @param attributes
	 *            collection of attributes for sorting
	 * @param reverse
	 *            order of sorting
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(List objects, final List attributes, final boolean reverse) {
		final ComparatorChain chain = new ComparatorChain();
		chain.addComparator(new Comparator() {
			@Override
			public int compare(Object object1, Object object2) {
				return applySort(object1, object2, attributes);
			}
		}, reverse);

		Collections.sort(objects, chain);
	}

	private static int applySort(Object object1, Object object2, List<String> attributes) {
		return getCompareValueByIndex(object1, object2, attributes, 0);
	}

	private static int getCompareValueByIndex(Object object1, Object object2, List<String> attributes, int index) {
		int value = -1;

		final String element = attributes.get(index);
		value = getCompareValue(object1, object2, element);

		if (value == 0) {
			if (index + 1 < attributes.size())
				value = getCompareValueByIndex(object1, object2, attributes, index + 1);
		}

		return value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int getCompareValue(Object object1, Object object2, String attribute) {
		int value = -1;

		try {
			final String methodName = constructMethodName(attribute);
			final Method method = object1.getClass().getMethod(methodName, null);
			final Class clazz = method.getReturnType();

			final Object result1 = method.invoke(object1, null);
			final Object result2 = method.invoke(object2, null);

			if (clazz.isAssignableFrom(Class.forName(Comparator.class.getName()))) {
				value = handleComparator(result1, result2);
			} else if (Class.forName(Comparable.class.getName()).isAssignableFrom(clazz)) {
				value = handleComparable(result1, result2);
			} else if (clazz.isPrimitive()) {
				value = handlePrimitive(value, result1, result2);
			} else {
				throw new RuntimeException("MultiAttributeSorter does not currently support ''" + clazz.getName() + "''!");
			}
		} catch (Exception e) {
			throw new RuntimeException("MultiAttributeSorter unable to perform the sorting...");
		}

		return value;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static int handleComparator(Object result1, Object result2) {
		final Comparator comparator1 = (Comparator) result1;
		final Comparator comparator2 = (Comparator) result2;
		return comparator1.compare(comparator1, comparator2);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static int handleComparable(Object result1, Object result2) {
		final Comparable comparator1 = (Comparable) result1;
		final Comparable comparator2 = (Comparable) result2;
		return comparator1.compareTo(comparator2);
	}

	private static int handlePrimitive(int value, Object result1, Object result2) {
		long f1 = ((Number) result1).longValue();
		long f2 = ((Number) result2).longValue();

		if (f1 < f2)
			value = LESS_THAN;
		else if (f1 > f2)
			value = GREATER_THAN;
		else if (f1 == f2)
			value = EQUAL;
		return value;
	}

	private final static String constructMethodName(String name) {
		final StringBuilder builder = new StringBuilder(GET_TAG);
		builder.append(name.substring(0, 1).toUpperCase());
		builder.append(name.substring(1));
		return builder.toString();
	}

}
