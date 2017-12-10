package com.arctrace.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.arctrace.domain.User;

/*
 * domain : com.arctrace.User
 */
@Repository
public interface UserDaoInterface {
	public void insertNewUser(User user);
	
	public List<User> selectAll();
	
	public List<User> selectUser(String email,String password);
}
