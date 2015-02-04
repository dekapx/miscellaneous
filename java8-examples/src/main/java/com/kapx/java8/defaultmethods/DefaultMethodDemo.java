package com.kapx.java8.defaultmethods;

/**
 * This class demonstrate the use of method reference and default method from interfaces.
 * 
 * @author KAPIL
 *
 */
public class DefaultMethodDemo {
	public static void main(String[] args) {
		TextFileWriter textFileWriter = new TextFileWriter();
		// this line represents method reference...
		FileWriter fileWriter = textFileWriter::write;
		fileWriter.write("text file contents");
	}
}
