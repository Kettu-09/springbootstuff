package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.LoginValidation;
import com.app.entity.User;
import com.app.service.LoginService;

@RestController
public class LoginController {

	private LoginService loginService;

	private LoginValidation validation;

	@Autowired
	public LoginController(LoginService loginService, LoginValidation validation) {
		this.loginService = loginService;

		this.validation = validation;
	}

	// save user details
	@PostMapping(path = "com/save")
	public String saveUser(@RequestBody User user) {

		validation.validateInput(user);

		loginService.save(user);
		return "User Save Scuccefully.";
	}

	// get user details by id.
	@GetMapping(path = "com/{loginId}")
	public User getUserById(@PathVariable(value = "loginId") Integer loginId) {

		return loginService.getUser(loginId);
	}

	// get user details by username.
	@GetMapping(path = "com/name/{userName}")
	public User getUserByName(@PathVariable(value = "userName") String userName) {

		return loginService.getUserName(userName);
	}

	// update user details
	@PutMapping(path = "/com/update")
	public User updateUserDetails(@RequestBody User user) {
		return loginService.updateUser(user);

	}

}
