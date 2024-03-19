package com.oline.store.storage;

import com.oline.store.enteties.Order;

import java.util.List;

public interface OrderStoringService {
	
	void saveOrders(List<Order> order);
	
	List<Order> loadOrders();
}
