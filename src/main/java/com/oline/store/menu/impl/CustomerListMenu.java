package com.oline.store.menu.impl;

import com.oline.store.configs.ApplicationContext;
import com.oline.store.enteties.User;
import com.oline.store.menu.Menu;
import com.oline.store.services.UserManagementService;
import com.oline.store.services.impl.DefaultUserManagementService;

import java.util.List;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		List<User> users = userManagementService.getUsers();

		if (users == null || users.size() == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** USERS *****");		
	}

}
