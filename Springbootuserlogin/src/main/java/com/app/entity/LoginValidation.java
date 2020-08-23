package com.app.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class LoginValidation {

	// Pattern pattern = Pattern.compile("[A-Za-z]+");

	public void validateInput(User user) {

		if (user.getLoginId() == null)
			throw new NullPointerException("Userid  not to be null");

		/*
		 * if (!pattern.matcher(user.getUserName()).matches()) throw new
		 * IllegalArgumentException("Enter only characters");
		 */

		if (StringUtils.isEmpty(user.getUserName()))
			throw new IllegalArgumentException("Please enter valid username");

		if (!(StringUtils.isAlpha(user.getUserName())))
			throw new IllegalArgumentException("Enter only characters");

		if (StringUtils.isEmpty(user.getPassword()))
			throw new NullPointerException("Password not to be null");

	}

}