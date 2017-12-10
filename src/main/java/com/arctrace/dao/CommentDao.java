package com.arctrace.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.arctrace.domain.Comment;
import com.arctrace.rowmapper.CommentRowMapper;
import com.arctrace.rowmapper.PostRowMapper;
import com.arctrace.util.BaseNamedParameterJdbcTemplate;
import com.arctrace.util.DateUtil;

@Repository
public class CommentDao extends BaseNamedParameterJdbcTemplate implements CommentDaoInterface {

	public void insertNewComment(Comment comment) {
		DateUtil du=new DateUtil();
		String sql = "INSERT INTO sandbox.guest.arctrace_comments (post_id,score,text,creation_date,user_display_name,user_id)"
				+ " values(:post_id,:score,:text,:creation_date,:user_display_name,:user_id)";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("post_id", comment.getPostId());
		param.addValue("score", comment.getScore());
		param.addValue("text", comment.getText());
		param.addValue("creation_date", du.getSqlDate(comment.getCreationDate()));
		param.addValue("user_display_name", comment.getUserDisplayName());
		param.addValue("user_id", comment.getUserId());
		getNamedParameterJdbcTemplate().update(sql, param);
	}

	public List<Comment> selectAllByPostId(int postId) {
		String sql = "SELECT * FROM sandbox.guest.arctrace_comments WHERE post_id=:post_id ORDER BY score DESC";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("post_id", postId);
		return getNamedParameterJdbcTemplate().query(sql, param, new CommentRowMapper());
	}

	public List<Comment> getTopCommentsByPostId(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comment selectCommentByCommnetId(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comment voteComment(int commentId, int vote) {
		// TODO Auto-generated method stub
		return null;
	}

}
