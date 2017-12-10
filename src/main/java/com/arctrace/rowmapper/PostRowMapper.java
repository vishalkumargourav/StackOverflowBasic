package com.arctrace.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arctrace.domain.Post;

public class PostRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int i) throws SQLException {
		Post post = new Post();
		post.setAcceptedAnswerId(rs.getInt("accepted_answer_id"));
		post.setAnswerCount(rs.getInt("answer_count"));
		post.setClosedDate(rs.getTimestamp("closed_date"));
		post.setCommentCount(rs.getInt("comment_count"));
		post.setCreationDate(rs.getTimestamp("creation_date"));
		post.setDeletionDate(rs.getTimestamp("deletion_date"));
		post.setDescription(rs.getString("description"));
		post.setFavoriteCount(rs.getInt("favorite_count"));
		post.setLastActivityDate(rs.getTimestamp("last_activity_date"));
		post.setLastEditDate(rs.getTimestamp("last_edit_date"));
		post.setLatestEditorDisplayName(rs.getString("latest_editor_display_name"));
		post.setLatestEditorUserId(rs.getInt("latest_editor_user_id"));
		post.setOwnerDisplayName(rs.getString("owner_display_name"));
		post.setOwnerUserId(rs.getInt("owner_user_id"));
		post.setParentId(rs.getInt("parent_id"));
		post.setPostId(rs.getInt("post_id"));
		post.setPostTypeId(rs.getInt("post_type_id"));
		post.setScore(rs.getInt("score"));
		post.setTags(rs.getString("tags"));
		post.setTitle(rs.getString("title"));
		post.setViewCount(rs.getInt("view_count"));
		return post;
	}

}
