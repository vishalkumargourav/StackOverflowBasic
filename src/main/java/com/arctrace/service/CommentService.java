package com.arctrace.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arctrace.dao.CommentDao;
import com.arctrace.domain.Comment;

@Service
public class CommentService implements CommentServiceInterface {
	@Autowired
	CommentDao commentDao;
	
	public void insertNewComment(Comment comment) {
		Date date=new Date();
		comment.setCreationDate(date);
		comment.setScore(0);
		commentDao.insertNewComment(comment);
	}

	public List<Comment> selectAllByPostId(int postId) {
		return commentDao.selectAllByPostId(postId);
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
