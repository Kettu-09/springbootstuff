package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repo.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	@Autowired
	public LoginServiceImpl(LoginDao loginDao) {

		this.loginDao = loginDao;
	}

	// save user details
	@Override
	public void save(User user) {
		loginDao.save(user);

	}

	// get user details by id
	@Override
	public User getUser(Integer id) {

		return loginDao.findByLoginId(id);
	}

	// get user details by name
	@Override
	public User getUserName(String name) {
		return loginDao.findByUserName(name);

	}

	// update user details
	@Override
	public User updateUser(User user) {

		User existingUser = loginDao.findByLoginId(user.getLoginId());

		existingUser.setUserName(user.getUserName());
		existingUser.setPassword(user.getPassword());

		return loginDao.save(existingUser);

	}

}
