package com.arctrace.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arctrace.domain.Post;

@Repository
public interface PostDaoInterface {
	public void insertNewPost(Post post);

	public List<Post> selectAll();

	public List<Post> getTopPosts(int n);

	public List<Post> getTopPostsUnAnswered(int n);

	public List<Post> selectPostById(int postId);

	public void votePost(int postId,int vote);

	public List<Post> getAnswersForPostId(int postId);

	public void increaseAnswerCount(int postId,int count);

	public void deletePost(int postId);

	public void increasePostScore(int postId,int sc);

	public List<Post> searchQuestion(Post post);

	public List<Post> getYourQuestions(int userId);
}
