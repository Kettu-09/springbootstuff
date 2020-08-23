package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface LoginDao extends JpaRepository<User, Integer> {

	User findByLoginId(Integer id);

	User findByUserName(String name);

}
