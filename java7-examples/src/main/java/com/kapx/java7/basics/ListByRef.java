package com.kapx.java7.basics;

import java.util.ArrayList;
import java.util.List;

public class ListByRef {
	private List<String> list;

	ListByRef(final List<String> list) {
		this.list = new ArrayList<String>(list);

	}

	public void display() {
		System.out.println(this.list);
	}

	public static void main(String[] args) {
		final List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		final ListByRef listByRef = new ListByRef(list);
		listByRef.display();

		list.remove(2);
		listByRef.display();

		list.add("D");
		list.add("E");
		listByRef.display();
	}
}
