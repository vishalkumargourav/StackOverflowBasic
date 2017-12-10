package com.arctrace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arctrace.domain.Post;

@Service
public interface PostServiceInterface {
	public void insertNewPost(Post post);

	public List<Post> selectAll();

	public List<Post> getTopPosts(int n);

	public List<Post> getTopPostsUnAnswered(int n);

	public Post selectPostById(int postId);

	public Post votePost(int postId,int vote);

	public List<Post> getAnswersForPostId(int postId);

	public void increaseAnswerCount(int postId,int count);

	public void deletePost(int postId);

	public void increasePostScore(int postId,int sc);

	public List<Post> searchQuestion(Post post);

	public List<Post> getYourQuestions(int userId);
}
