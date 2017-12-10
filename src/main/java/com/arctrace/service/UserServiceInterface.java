package com.arctrace.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.arctrace.domain.User;

@Service
public interface UserServiceInterface {
	public void insertNewUser(User user);

	public List<User> selectAll();

	public User selectUser(String email, String password);
}
