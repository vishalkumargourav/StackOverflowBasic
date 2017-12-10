package com.arctrace.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arctrace.dao.VoteDao;
import com.arctrace.domain.Vote;

@Service
public class VoteService implements VoteServiceInterface{
	@Autowired
	VoteDao voteDao;
	
	public Vote selectVoteByUserIdAndPostId(int userId, int postId) {
		return voteDao.selectVoteByUserIdAndPostId(userId, postId);
	}

	public void insertVote(Vote vote) {
		Date date=new Date();
		vote.setCreationDate(date);
		voteDao.insertVote(vote);
	}

	public void deleteVote(int voteId) {
		voteDao.deleteVote(voteId);
	}
	
}
