package com.arctrace.dao;

import org.springframework.stereotype.Repository;

import com.arctrace.domain.Vote;

@Repository
public interface VoteDaoInterface {
	public Vote selectVoteByUserIdAndPostId(int userId, int postId);

	public void insertVote(Vote vote);

	public void deleteVote(int voteId);
}
