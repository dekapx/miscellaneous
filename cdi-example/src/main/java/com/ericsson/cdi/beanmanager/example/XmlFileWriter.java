package com.ericsson.cdi.beanmanager.example;

import javax.inject.Named;

@Named("xmlFileWriter")
public class XmlFileWriter implements FileWriter {

    @Override
    public void write(final String text) {
        System.out.println("writing [ " + text + " ] to XmlFile.");
    }

}
