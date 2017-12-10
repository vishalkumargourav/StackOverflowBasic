package com.arctrace.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arctrace.dao.PostDao;
import com.arctrace.domain.Post;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    PostDao postDao;

    public void insertNewPost(Post post) {
        // 1. Its a question postTypeId = 0
        Date date = new Date();
        post.setCreationDate(date);
        post.setScore(0);
        post.setViewCount(0);
        post.setLastEditDate(date);
        post.setLastActivityDate(date);
        if (post.getPostTypeId() == 0) {
            post.setAcceptedAnswerId(-1);
            post.setParentId(-1);
            String[] arr = post.getTags().split(";", -1);
            if (arr.length > 0) {
                StringBuilder nameBuilder = new StringBuilder();
                for (String n : arr) {
                    nameBuilder.append("'").append(n.replace("'", "\\'")).append("',");
                }
                nameBuilder.deleteCharAt(nameBuilder.length() - 1);
                post.setTags(nameBuilder.toString());
            } else {
                post.setTags("");
            }
            post.setAnswerCount(0);
            post.setCommentCount(0);
            post.setFavoriteCount(0);
        } else {
            // 2. Its an answer postTypeId = 1
            // select question and increase answer count for that
            Post quest = postDao.selectPostById(post.getParentId()).get(0);
            increaseAnswerCount(quest.getPostId(), 1);
            post.setCommentCount(0);
            post.setFavoriteCount(0);
        }
        postDao.insertNewPost(post);
    }

    public List<Post> selectAll() {

        return null;
    }

    public List<Post> getTopPosts(int n) {
        return postDao.getTopPosts(n);
    }

    public Post selectPostById(int postId) {
        List<Post> list = postDao.selectPostById(postId);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public Post votePost(int postId, int vote) {
        postDao.votePost(postId, vote);
        return selectPostById(postId);
    }

    public List<Post> getAnswersForPostId(int postId) {
        return postDao.getAnswersForPostId(postId);
    }

    public void increaseAnswerCount(int postId, int count) {
        postDao.increaseAnswerCount(postId, count);
    }

    public void deletePost(int postId) {
        postDao.deletePost(postId);
    }

    public List<Post> getTopPostsUnAnswered(int n) {
        return postDao.getTopPostsUnAnswered(n);
    }

    public void increasePostScore(int postId, int sc) {
        postDao.increasePostScore(postId, sc);
    }

    public List<Post> searchQuestion(Post post) {
        return postDao.searchQuestion(post);
    }

    public List<Post> getYourQuestions(int userId) {
        // TODO Auto-generated method stub
        return postDao.getYourQuestions(userId);
    }
}