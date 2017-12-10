package com.arctrace.service;

import org.springframework.stereotype.Service;

import com.arctrace.domain.Vote;

@Service
public interface VoteServiceInterface {
	public Vote selectVoteByUserIdAndPostId(int userId,int postId);
	
	public void insertVote(Vote vote);
	
	public void deleteVote(int voteId);
}
