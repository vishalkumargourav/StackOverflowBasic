package com.arctrace.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arctrace.domain.Vote;

public class VoteRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int i) throws SQLException {
		Vote vote = new Vote();
		vote.setCreationDate(rs.getTimestamp("creation_date"));
		vote.setId(rs.getInt("id"));
		vote.setPostId(rs.getInt("post_id"));
		vote.setUserId(rs.getInt("user_id"));
		vote.setVoteTypeId(rs.getInt("vote_type_id"));
		return vote;
	}

}
