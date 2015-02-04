package com.kapx.java8.defaultmethods;

public interface FileWriter {
	void write(String contents);

	default String formatContents(final String contents) {
		return "||| " + contents + " |||";
	};
}
