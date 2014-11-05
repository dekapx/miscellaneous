package com.kapx.weld.cdi.util;

import javax.inject.Inject;

import com.kapx.weld.cdi.annotation.FileWriterType;
import com.kapx.weld.cdi.annotation.FileWriterType.WriterType;
import com.kapx.weld.cdi.beans.FileWriter;

public class FileWriterUtil {

	@Inject
	@FileWriterType(WriterType.XML)
	private FileWriter xmlFileWriter;

	public void writeToFile(final String contents) {
		xmlFileWriter.write(contents);
	}
}
