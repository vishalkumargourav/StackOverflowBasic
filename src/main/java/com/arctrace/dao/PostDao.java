package com.arctrace.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.arctrace.domain.Post;
import com.arctrace.rowmapper.PostRowMapper;
import com.arctrace.util.BaseNamedParameterJdbcTemplate;
import com.arctrace.util.DateUtil;

@Repository
public class PostDao extends BaseNamedParameterJdbcTemplate implements PostDaoInterface {

    public void insertNewPost(Post post) {
        DateUtil du = new DateUtil();
        String sql = "INSERT INTO sandbox.guest.arctrace_posts (post_type_id, accepted_answer_id,parent_id,creation_date,"
                + "score,view_count,owner_user_id,owner_display_name,latest_editor_user_id,"
                + "latest_editor_display_name,last_edit_date,last_activity_date,title,tags,"
                + "answer_count,comment_count,favorite_count,description)"
                + " values(:post_type_id,:accepted_answer_id,:parent_id,:creation_date,:score,:view_count,:owner_user_id,:owner_display_name,:latest_editor_user_id,:latest_editor_display_name,:last_edit_date,:last_activity_date,:title,:tags,:answer_count,:comment_count,:favorite_count,:description)";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("post_type_id", post.getPostTypeId());
        param.addValue("accepted_answer_id", post.getAcceptedAnswerId());
        param.addValue("parent_id", post.getParentId());
        param.addValue("creation_date", du.getSqlDate(post.getCreationDate()));
        param.addValue("score", post.getScore());
        param.addValue("view_count", post.getViewCount());
        param.addValue("owner_user_id", post.getOwnerUserId());
        param.addValue("owner_display_name", post.getOwnerDisplayName());
        param.addValue("latest_editor_user_id", post.getLatestEditorUserId());
        param.addValue("latest_editor_display_name", post.getLatestEditorDisplayName());
        param.addValue("last_edit_date", du.getSqlDate(post.getLastEditDate()));
        param.addValue("last_activity_date", du.getSqlDate(post.getLastActivityDate()));
        param.addValue("title", post.getTitle());
        param.addValue("tags", post.getTags());
        param.addValue("answer_count", post.getAnswerCount());
        param.addValue("comment_count", post.getCommentCount());
        param.addValue("favorite_count", post.getFavoriteCount());
        param.addValue("description", post.getDescription());
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    public List<Post> selectAll() {
        return null;
    }

    public List<Post> getTopPosts(int n) {
        String sql = "SELECT top (:count) * FROM sandbox.guest.arctrace_posts WHERE post_type_id=0 AND answer_count<>0 AND deletion_date IS NULL ORDER BY score DESC";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("count", n);
        return getNamedParameterJdbcTemplate().query(sql, param, new PostRowMapper());
    }

    public List<Post> selectPostById(int postId) {
        String sql = "SELECT * FROM sandbox.guest.arctrace_posts WHERE post_id=:post_id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("post_id", postId);
        return (List<Post>) getNamedParameterJdbcTemplate().query(sql, param, new PostRowMapper());
    }

    public void votePost(int postId, int vote) {
        String sql = "UPDATE sandbox.guest.arctrace_posts SET score=score+(:vote) where post_id=:post_id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("post_id", postId);
        param.addValue("vote", vote);
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    public List<Post> getAnswersForPostId(int postId) {
        // POST_TYPE_ID is 1 for answers and 0 for questions
        String sql = "SELECT * FROM sandbox.guest.arctrace_posts WHERE post_type_id=1 AND parent_id=:parent_id AND deletion_date IS NULL ORDER BY score DESC";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("parent_id", postId);
        return (List<Post>) getNamedParameterJdbcTemplate().query(sql, param, new PostRowMapper());
    }

    public void increaseAnswerCount(int postId, int count) {
        String sql = "UPDATE sandbox.guest.arctrace_posts SET answer_count=answer_count+(:count) where post_id=:post_id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("post_id", postId);
        param.addValue("count", count);
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    public void deletePost(int postId) {
        String sql = "UPDATE sandbox.guest.arctrace_posts SET deletion_date=:date where post_id=:post_id";
        DateUtil du = new DateUtil();
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("post_id", postId);
        param.addValue("date", du.getSqlDate(new Date()));
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    public List<Post> getTopPostsUnAnswered(int n) {
        String sql = "SELECT top (:count) * FROM sandbox.guest.arctrace_posts WHERE post_type_id=0 AND answer_count=0 AND deletion_date IS NULL ORDER BY score DESC";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("count", n);
        return getNamedParameterJdbcTemplate().query(sql, param, new PostRowMapper());
    }

    public void increasePostScore(int postId, int sc) {
        String sql = "UPDATE sandbox.guest.arctrace_posts SET score=score+:score_inc where post_id=:post_id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("post_id", postId);
        param.addValue("score_inc", sc);
        getNamedParameterJdbcTemplate().update(sql, param);
    }

    public List<Post> searchQuestion(Post post) {
        String sql = "SELECT * FROM sandbox.guest.arctrace_posts where lower(title) like :title or lower(description) like :title1 and post_type_id=0";
        String title = post.getTitle();
        String title_low = "%" + title.toLowerCase().trim() + "%";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("title", title_low);
        param.addValue("title1", title_low);
        return getNamedParameterJdbcTemplate().query(sql, param, new PostRowMapper());
    }

    public List<Post> getYourQuestions(int userId) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM sandbox.guest.arctrace_posts WHERE post_type_id=0 AND deletion_date  IS NULL AND owner_user_id=:id ORDER BY score DESC";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", userId);
        return getNamedParameterJdbcTemplate().query(sql, param, new PostRowMapper());
    }
}
