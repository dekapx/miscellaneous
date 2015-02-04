package com.kapx.java8.defaultmethods;

public class TextFileWriter implements FileWriter {

	@Override
	public void write(String contents) {
		// invoking default method...
		System.out.println(formatContents(contents));
	}

}
