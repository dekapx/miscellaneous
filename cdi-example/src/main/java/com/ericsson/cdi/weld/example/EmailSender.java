package com.ericsson.cdi.weld.example;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EmailSender {
    @Inject
    private TextFormatter formatter;

    public void sendEmail(String text) {
        String formattedText = formatter.formatText(text);
        System.out.println("sending email with " + formattedText);
    }
}
