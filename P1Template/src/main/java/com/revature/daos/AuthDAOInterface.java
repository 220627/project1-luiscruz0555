package com.revature.daos;

import com.revature.models.User;

public interface AuthDAOInterface {
	
	public User login(String username, String password);
	
	

}
