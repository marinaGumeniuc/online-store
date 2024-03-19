package com.oline.store.services.impl;

import com.oline.store.services.MailSander;

public class DefaultMailSender implements MailSander {

    private static DefaultMailSender instance;

    public static DefaultMailSender getInstance() {
        if (instance == null) {
            instance = new DefaultMailSender();
        }
        return instance;
    }

    @Override
    public void sendMail(String sendTo, String messageToSend) {

    }
}
