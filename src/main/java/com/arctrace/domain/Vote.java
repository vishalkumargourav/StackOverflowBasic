package com.arctrace.domain;

import java.util.Date;

public class Vote {
	private int id;
	private int postId;
	private int voteTypeId; //0->upvote and 1->downvote
	private int userId;
	private Date creationDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getVoteTypeId() {
		return voteTypeId;
	}
	public void setVoteTypeId(int voteTypeId) {
		this.voteTypeId = voteTypeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Vote() {
		
	}
}
