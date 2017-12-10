package com.arctrace.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.arctrace.domain.User;
import com.arctrace.rowmapper.UserRowMapper;
import com.arctrace.util.BaseNamedParameterJdbcTemplate;
import com.arctrace.util.DateUtil;

@Repository
public class UserDao extends BaseNamedParameterJdbcTemplate implements UserDaoInterface {

	public void insertNewUser(User user) {
		DateUtil du=new DateUtil();
		String sql = "INSERT INTO sandbox.guest.arctrace_users (reputation,creation_date,display_name,last_access_date,website_url,location,about_me,views,up_votes,down_votes,profile_image_url,email_hash,account_id,age,password)"
				+ " values(:reputation,:creation_date,:display_name,:last_access_date,:website_url,:location,:about_me,:views,:up_votes,:down_votes,:profile_image_url,:email_hash,:account_id,:age,:password)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("reputation", user.getReputation());
		param.addValue("creation_date", du.getSqlDate(user.getCreationDate()));
		param.addValue("display_name", user.getDisplayName());
		param.addValue("last_access_date", du.getSqlDate(user.getLastAccessDate()));
		param.addValue("website_url", user.getWebsiteUrl());
		param.addValue("location", user.getLocation());
		param.addValue("about_me", user.getAboutMe());
		param.addValue("views", user.getViews());
		param.addValue("up_votes", user.getUpVotes());
		param.addValue("down_votes", user.getDownVotes());
		param.addValue("profile_image_url", user.getProfileImageUrl());
		param.addValue("email_hash", user.getEmailHash());
		param.addValue("account_id", user.getAccountId());
		param.addValue("age", user.getAge());
		param.addValue("password", user.getPassword());
		getNamedParameterJdbcTemplate().update(sql, param);
	}

	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> selectUser(String email, String password) {
		String sql = "SELECT * FROM sandbox.guest.arctrace_users WHERE email_hash=:email AND password=:password";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("email", email);
		param.addValue("password", password);
		return (List<User>) getNamedParameterJdbcTemplate().query(sql, param, new UserRowMapper());

				//queryForObject(sql, param, new UserRowMapper());
	}

}
