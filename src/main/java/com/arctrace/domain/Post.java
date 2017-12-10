package com.arctrace.domain;

import java.util.Date;

public class Post {
	private int postId;
	private int postTypeId;
	private int acceptedAnswerId;
	private int parentId;
	private Date creationDate;
	private Date deletionDate;
	private int score;
	private int viewCount;
	private int ownerUserId;
	private String ownerDisplayName;
	private int latestEditorUserId;
	private String latestEditorDisplayName;
	private Date lastEditDate;
	private Date lastActivityDate;
	private String title;
	private String tags;
	private int answerCount;
	private int commentCount;
	private int favoriteCount;
	private Date closedDate;
	private String description;
	
	public Post(){
		
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getPostTypeId() {
		return postTypeId;
	}
	public void setPostTypeId(int postTypeId) {
		this.postTypeId = postTypeId;
	}
	public int getAcceptedAnswerId() {
		return acceptedAnswerId;
	}
	public void setAcceptedAnswerId(int acceptedAnswerId) {
		this.acceptedAnswerId = acceptedAnswerId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDeletionDate() {
		return deletionDate;
	}
	public void setDeletionDate(Date deletionDate) {
		this.deletionDate = deletionDate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int view_count) {
		this.viewCount = view_count;
	}
	public int getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public String getOwnerDisplayName() {
		return ownerDisplayName;
	}
	public void setOwnerDisplayName(String ownerDisplayName) {
		this.ownerDisplayName = ownerDisplayName;
	}
	public int getLatestEditorUserId() {
		return latestEditorUserId;
	}
	public void setLatestEditorUserId(int latestEditorUserId) {
		this.latestEditorUserId = latestEditorUserId;
	}
	public String getLatestEditorDisplayName() {
		return latestEditorDisplayName;
	}
	public void setLatestEditorDisplayName(String latestEditorDisplayName) {
		this.latestEditorDisplayName = latestEditorDisplayName;
	}
	public Date getLastEditDate() {
		return lastEditDate;
	}
	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}
	public Date getLastActivityDate() {
		return lastActivityDate;
	}
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public Date getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTypeId=" + postTypeId + ", acceptedAnswerId=" + acceptedAnswerId
				+ ", parentId=" + parentId + ", creationDate=" + creationDate + ", deletionDate=" + deletionDate
				+ ", score=" + score + ", view_count=" + viewCount + ", ownerUserId=" + ownerUserId
				+ ", ownerDisplayName=" + ownerDisplayName + ", latestEditorUserId=" + latestEditorUserId
				+ ", latestEditorDisplayName=" + latestEditorDisplayName + ", lastEditDate=" + lastEditDate
				+ ", lastActivityDate=" + lastActivityDate + ", title=" + title + ", tags=" + tags + ", answerCount="
				+ answerCount + ", commentCount=" + commentCount + ", favoriteCount=" + favoriteCount + ", closedDate="
				+ closedDate + "]";
	}
}
