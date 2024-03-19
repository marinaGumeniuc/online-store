package com.oline.store.services;

import com.oline.store.enteties.User;

import java.util.List;

public interface UserManagementService {

	String registerUser(User user);
	
	List<User> getUsers();

	User getUserByEmail(String userEmail);

}
