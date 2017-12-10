package com.arctrace.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arctrace.domain.Comment;

public class CommentRowMapper implements RowMapper{

	public Object mapRow(ResultSet rs, int i) throws SQLException {
		Comment comment = new Comment();
		comment.setCommentId(rs.getInt("comment_id"));
		comment.setCreationDate(rs.getTimestamp("creation_date"));
		comment.setPostId(rs.getInt("post_id"));
		comment.setScore(rs.getInt("score"));
		comment.setText(rs.getString("text"));
		comment.setUserDisplayName(rs.getString("user_display_name"));
		comment.setUserId(rs.getInt("user_id"));
		return comment;
	}

}
