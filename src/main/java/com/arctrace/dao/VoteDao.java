package com.arctrace.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.arctrace.domain.Vote;
import com.arctrace.rowmapper.VoteRowMapper;
import com.arctrace.util.BaseNamedParameterJdbcTemplate;
import com.arctrace.util.DateUtil;

@Repository
public class VoteDao extends BaseNamedParameterJdbcTemplate implements VoteDaoInterface {

	public Vote selectVoteByUserIdAndPostId(int userId, int postId) {
		String sql = "SELECT * FROM sandbox.guest.arctrace_votes where user_id=:user_id AND post_id=:post_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", userId);
		param.addValue("post_id", postId);
		List<Vote> votes = (List<Vote>) getNamedParameterJdbcTemplate().query(sql, param, new VoteRowMapper());
		if (votes != null && !votes.isEmpty())
			return votes.get(0);
		return null;
	}

	public void insertVote(Vote vote) {
		DateUtil du = new DateUtil();
		String sql = "INSERT INTO sandbox.guest.arctrace_votes (post_id,vote_type_id,user_id,creation_date)"
				+ " values(:post_id,:vote_type_id,:user_id,:creation_date)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("post_id", vote.getPostId());
		param.addValue("vote_type_id", vote.getVoteTypeId());
		param.addValue("creation_date", du.getSqlDate(vote.getCreationDate()));
		param.addValue("user_id", vote.getUserId());
		getNamedParameterJdbcTemplate().update(sql, param);
	}

	public void deleteVote(int voteId) {
		String sql = "DELETE FROM sandbox.guest.arctrace_votes WHERE id = :vote_id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("vote_id", voteId);
		getNamedParameterJdbcTemplate().update(sql, param);
	}

}
