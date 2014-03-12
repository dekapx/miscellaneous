package com.ericsson.cdi.beanmanager.example;

import javax.inject.Named;

@Named("textFileWriter")
public class TextFileWriter implements FileWriter {

    @Override
    public void write(final String text) {
        System.out.println("writing [ " + text + " ] to TextFile.");
    }
}
