package com.arctrace.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arctrace.domain.User;

/*
 * domain : com.arctrace.User
 */
public class UserRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int i) throws SQLException {
		User user = new User();
		user.setAboutMe(rs.getString("about_me"));
		user.setAccountId(rs.getString("account_id"));
		user.setAge(rs.getInt("age"));
		user.setCreationDate(rs.getDate("creation_date"));
		user.setDisplayName(rs.getString("display_name"));
		user.setDownVotes(rs.getInt("down_votes"));
		user.setEmailHash(rs.getString("email_hash"));
		user.setId(rs.getInt("id"));
		user.setLastAccessDate(rs.getDate("last_access_date"));
		user.setLocation(rs.getString("location"));
		user.setPassword(rs.getString("password"));
		user.setProfileImageUrl(rs.getString("profile_image_url"));
		user.setReputation(rs.getInt("reputation"));
		user.setUpVotes(rs.getInt("up_votes"));
		user.setViews(rs.getInt("views"));
		user.setWebsiteUrl(rs.getString("website_url"));
		return user;
	}
	
}
