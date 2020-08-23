package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	private Integer loginId;
	private String userName;
	private String password;

}
