package com.arctrace.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arctrace.domain.Comment;

@Repository
public interface CommentDaoInterface {
	public void insertNewComment(Comment comment);

	public List<Comment> selectAllByPostId(int postId);
	
	public List<Comment> getTopCommentsByPostId(int n);
	
	public Comment selectCommentByCommnetId(int commentId);
	
	public Comment voteComment(int commentId,int vote);
}
