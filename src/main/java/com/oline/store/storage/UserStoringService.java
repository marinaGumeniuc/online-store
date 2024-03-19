package com.oline.store.storage;

import com.oline.store.enteties.User;

import java.util.List;

public interface UserStoringService {
	
	void saveUser(User user);
	
	List<User> loadUsers();
	
}
