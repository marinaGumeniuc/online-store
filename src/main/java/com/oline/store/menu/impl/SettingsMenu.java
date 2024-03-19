package com.oline.store.menu.impl;

import com.oline.store.configs.ApplicationContext;
import com.oline.store.menu.Menu;

import java.util.Locale;
import java.util.Scanner;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email" + " 'menu' - to navigate back to main menu";


	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Menu menuToNavigate = null;
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next().toLowerCase(Locale.ROOT);
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to change your account settings");
			new MainMenu().start();
			return;
		} else {
			System.out.println(SETTINGS);
			switch (userInput) {
				case "1":
					menuToNavigate = new ChangePasswordMenu();
					break;
				case "2":
					menuToNavigate = new ChangeEmailMenu();
					break;
				case "3":
					menuToNavigate = new SendPasswordByEmailMenu();

				case "menu":
					new MainMenu().start();
					break;
					default:
					System.out.println("Only 1, 2 is allowed. Try one more time.");
					new SettingsMenu().start();


			}

			new MainMenu().start();

		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SETTINGS *****");

	}

}
