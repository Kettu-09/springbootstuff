package com.app.service;

import com.app.entity.User;

public interface LoginService {

	//save user
	void save(User user);

	// get user details by id.
	public User getUser(Integer id);

	// get user details by username.
	public User getUserName(String name);
	
	// update user details
	public User updateUser(User user);

}
