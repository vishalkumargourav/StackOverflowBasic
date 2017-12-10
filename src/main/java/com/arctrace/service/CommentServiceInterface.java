package com.arctrace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arctrace.domain.Comment;

@Service
public interface CommentServiceInterface {
	public void insertNewComment(Comment comment);

	public List<Comment> selectAllByPostId(int postId);
	
	public List<Comment> getTopCommentsByPostId(int n);
	
	public Comment selectCommentByCommnetId(int commentId);
	
	public Comment voteComment(int commentId,int vote);
}
