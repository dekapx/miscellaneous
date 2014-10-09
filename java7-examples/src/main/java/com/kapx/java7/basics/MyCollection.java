package com.kapx.java7.basics;

import java.util.ArrayList;
import java.util.List;

public class MyCollection {
	private List<String> elements;
	
	public MyCollection() {
		elements = new ArrayList<>();
	}
	
	public void addElement(String element) {
		if (element == null || element.isEmpty()) {
			throw new IllegalArgumentException("element must not be null");
		}
		
		elements.add(element);
	}
	
	public void removeElement(String element) {
		if (element == null || element.isEmpty()) {
			throw new IllegalArgumentException("element must not be null");
		}
		
		elements.remove(element);
	}
}
