package com.kapx.weld.cdi.beans;

import com.kapx.weld.cdi.annotation.FileWriterType;
import com.kapx.weld.cdi.annotation.FileWriterType.WriterType;

@FileWriterType(WriterType.TEXT)
public class TextFileWriter implements FileWriter {

	@Override
	public void write(String contents) {
		System.out.println("TextFileWriter :: " + contents);
	}

}
