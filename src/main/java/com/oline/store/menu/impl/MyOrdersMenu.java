package com.oline.store.menu.impl;

import com.oline.store.configs.ApplicationContext;
import com.oline.store.enteties.Order;
import com.oline.store.menu.Menu;
import com.oline.store.services.OrderManagementService;
import com.oline.store.services.impl.DefaultOrderManagementService;

import java.util.List;


public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;


	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();

	}


	@Override
	public void start() {
		printMenuHeader();
		if(context.getLoggedInUser() == null){
			System.out.println("Please, log in or create new account to see list of your orders");
			new MainMenu().start();
			return;
		} else {
printUsersOrdersToConsole();
		}

		context.getMainMenu();

	}

	public void printUsersOrdersToConsole() {
		List<Order> loggedInUsersOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
		if (loggedInUsersOrders == null || loggedInUsersOrders.size() == 0) {
			System.out.println(
					"Unfortunately, you don't have any orders yet. "
							+ "Navigate back to main menu to place a new order");
		} else {
			for (Order order : loggedInUsersOrders) {
				System.out.println(order);
			}
		}
	}


	@Override
	public void printMenuHeader() {
		System.out.println("***** MY ORDERS *****");
	}

}
