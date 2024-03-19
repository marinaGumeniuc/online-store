package com.oline.store.services.impl;


import com.oline.store.enteties.User;
import com.oline.store.enteties.impl.DefaultUser;
import com.oline.store.services.MailSander;
import com.oline.store.services.ResetPasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DefaultResetPasswordServiceTest {
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private ResetPasswordService resetPasswordService = new DefaultResetPasswordService();

    @Mock
    private MailSander mailSanderMock;

    @Captor
    private ArgumentCaptor<String> captor;

 @Test
    void shouldSendToUserEmail(){
     User user = new DefaultUser();
     String userEmail = "testemail@email.com";
     user.setEmail(userEmail);

     resetPasswordService.resetPasswordForUser(user);

     verify(mailSanderMock).sendMail(captor.capture(), anyString());

     assertEquals("User email does not match", captor.getValue(), userEmail);
 }

 @Test
    void shouldSendPasswordInfo(){
     User user = new DefaultUser();
     String userPass = "pass";
     user.setPassword(userPass);

     resetPasswordService.resetPasswordForUser(user);

     verify(mailSanderMock).sendMail(any(),captor.capture());

     assertTrue("Password information not found in email", captor.getValue().split(":")[1].trim().equals(userPass));
 }
}

