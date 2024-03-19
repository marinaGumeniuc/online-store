package com.oline.store.menu.impl;

import com.oline.store.configs.ApplicationContext;
import com.oline.store.menu.Menu;
import com.oline.store.services.UserManagementService;
import com.oline.store.services.impl.DefaultUserManagementService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SendPasswordByEmailMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    Scanner sc = new Scanner(System.in);
    String userInput = sc.next();


    @Override
    public void start() {
        printMenuHeader();
        System.out.println("Please,  enter your email: ");
        String email = String.valueOf(userManagementService.getUserByEmail(userInput));
        System.out.println("Your password has been sent to your email. Please, check the mailbox. You will receive the email within the next 5 minutes");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() ->  sendPassword(email));
        executorService.execute(() -> context.getMainMenu().start());
        System.out.println("Navigating to different menu...");


        executorService.shutdown();
    }

    static void sendPassword(String email){
        System.out.println("Sending reset email to " + email + "...");

        try {
            Thread.sleep(3000); // Simulating email sending time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Reset email sent to " + email);
    }



    @Override
    public void printMenuHeader() {
        System.out.println("***** RESET PASSWORD MENU *****");
    }
}
