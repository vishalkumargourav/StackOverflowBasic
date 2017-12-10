package com.arctrace.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arctrace.dao.UserDao;
import com.arctrace.dao.UserDaoInterface;
import com.arctrace.domain.User;

@Service
public class UserService implements UserServiceInterface {
	@Autowired
	UserDao userDao;

	public void insertNewUser(User user) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		user.setCreationDate(date);
		user.setReputation(0);
		user.setLastAccessDate(date);
		user.setViews(0);
		user.setUpVotes(0);
		user.setDownVotes(0);
		user.setAccountId(user.getEmailHash());
		userDao.insertNewUser(user);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User selectUser(String email, String password) {
		List<User> list = userDao.selectUser(email, password);
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
