package com.kapx.xembly.book;

import org.xembly.Directive;
import org.xembly.Directives;

public class Book {
	private final String isbn;
	private final String title;

	public Book(final String isbn, final String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public Iterable<Directive> toXembly() {
		return new Directives().add("book").add("isbn").set(this.isbn).up().add("title").set(this.title).up().up();
	}
}
