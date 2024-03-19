package com.oline.store.services.impl;

import com.oline.store.services.MailSander;
import com.oline.store.services.ResetPasswordService;
import com.oline.store.enteties.User;

public class DefaultResetPasswordService implements ResetPasswordService {
   private MailSander mailSander;

    {
        mailSander = DefaultMailSender.getInstance();
    }


    @Override
    public void resetPasswordForUser(User user) {
        mailSander.sendMail(user.getEmail(), "Please, use this password to login: " + user.getPassword());

    }


}
