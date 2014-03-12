package com.ericsson.cdi.weld.example;

import javax.inject.Inject;

public class OutlookManager {
    @Inject
    private EmailSender emailSender;

    public void compose(final String textMessage) {
        emailSender.sendEmail(textMessage);
    }

}
