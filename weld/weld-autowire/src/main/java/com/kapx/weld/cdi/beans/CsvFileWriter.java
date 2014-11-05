package com.kapx.weld.cdi.beans;

import com.kapx.weld.cdi.annotation.FileWriterType;
import com.kapx.weld.cdi.annotation.FileWriterType.WriterType;

@FileWriterType(WriterType.CSV)
public class CsvFileWriter implements FileWriter {

	@Override
	public void write(String contents) {
		System.out.println("CsvFileWriter :: " + contents);
	}

}
