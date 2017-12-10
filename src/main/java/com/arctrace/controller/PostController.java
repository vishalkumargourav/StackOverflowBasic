package com.arctrace.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arctrace.domain.Comment;
import com.arctrace.domain.Post;
import com.arctrace.domain.User;
import com.arctrace.domain.Vote;
import com.arctrace.service.CommentService;
import com.arctrace.service.PostService;
import com.arctrace.service.VoteService;

@Controller
public class PostController {
	@Autowired
	PostService postServie;
	@Autowired
	CommentService commentService;
	@Autowired
	VoteService voteService;

	@RequestMapping("viewPost")
	public String viewPost(@RequestParam("postId") Integer postId, Model m, HttpSession session) {
		Post post;
		Comment comment;
		User user;
		List<Comment> comments;
		try {
			post = postServie.selectPostById(postId);
			m.addAttribute("postQuest", post);
			comment = new Comment();
			comment.setPostId(postId);
			comment.setScore(0);
			user = (User) session.getAttribute("user");
			comment.setUserDisplayName(user.getDisplayName());
			comment.setUserId(user.getId());
			m.addAttribute("commentCommand", comment);
			comments = commentService.selectAllByPostId(postId);
			m.addAttribute("allComments", comments);
			m.addAttribute("answerCommand", new Post());
			m.addAttribute("allAnswers", postServie.getAnswersForPostId(postId));
			return "viewPost";
		} catch (Exception e) {
			return "redirect:/home.htm";
		}
	}

	@RequestMapping("votePost")
	public String votePost(@RequestParam Integer postId, @RequestParam Integer vote, Model m, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Vote voteObj = (Vote) voteService.selectVoteByUserIdAndPostId(user.getId(), postId);
		Post postQuest = postServie.selectPostById(postId);
		m.addAttribute("postQuest", postQuest);
		if(user.getId() == postQuest.getOwnerUserId()) {

        }else if (null == voteObj) {
			try {
				voteObj = new Vote();
				voteObj.setCreationDate(new Date());
				voteObj.setPostId(postId);
				voteObj.setUserId(user.getId());
				int type = (vote == 1) ? 0 : 1;
				voteObj.setVoteTypeId(type);
				postServie.votePost(postId, vote);
				voteService.insertVote(voteObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ((voteObj.getVoteTypeId() == 0 && vote == -1) || (voteObj.getVoteTypeId() == 1 && vote == 1)) {
			voteService.deleteVote(voteObj.getId());
			voteObj.setPostId(postId);
			if (vote == -1) {
				postServie.votePost(postId, -2);
				voteObj.setVoteTypeId(1);
			} else {
				postServie.votePost(postId, 2);
				voteObj.setVoteTypeId(0);
			}
			voteService.insertVote(voteObj);
		}
		return "redirect:/viewPost.htm?postId=" + postId;
	}

	@RequestMapping("answerSave")
	public String answerSave(@RequestParam Integer postId, @ModelAttribute("answerCommand") Post answer, Model m,
			HttpSession session) {
		answer.setParentId(postId);
		answer.setPostTypeId(1); // because it is an answer
		User user = (User) session.getAttribute("user");
		answer.setOwnerUserId(user.getId());
		answer.setOwnerDisplayName(user.getDisplayName());
		answer.setLatestEditorUserId(user.getId());
		answer.setLatestEditorDisplayName(user.getDisplayName());
		try {
			postServie.insertNewPost(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/viewPost.htm?postId=" + postId;
	}

	@RequestMapping("voteAnswer")
	public String voteAnswer(@RequestParam Integer answerPostId, @RequestParam Integer vote, Model m,
			HttpSession session) {
		Post answer = postServie.selectPostById(answerPostId);
		User user = (User) session.getAttribute("user");
		Vote voteObj = (Vote) voteService.selectVoteByUserIdAndPostId(user.getId(), answerPostId);
		m.addAttribute("postQuest", postServie.selectPostById(answer.getParentId()));
		if(user.getId() == answer.getOwnerUserId()) {

		}else if (null == voteObj) {
			try {
				voteObj = new Vote();
				voteObj.setCreationDate(new Date());
				voteObj.setPostId(answerPostId);
				voteObj.setUserId(user.getId());
				int type = (vote == 1) ? 0 : 1;
				voteObj.setVoteTypeId(type);
				postServie.votePost(answerPostId, vote);
				voteService.insertVote(voteObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ((voteObj.getVoteTypeId() == 0 && vote == -1) || (voteObj.getVoteTypeId() == 1 && vote == 1)) {
			voteService.deleteVote(voteObj.getId());
			voteObj.setPostId(answerPostId);
			if (vote == -1) {
				postServie.votePost(answerPostId, -2);
				voteObj.setVoteTypeId(1);
			} else {
				postServie.votePost(answerPostId, 2);
				voteObj.setVoteTypeId(0);
			}
			voteService.insertVote(voteObj);
		}
		return "redirect:/viewPost.htm?postId=" + answer.getParentId();
	}

	@RequestMapping("deleteAnswer")
	public String deleteAnswer(@RequestParam Integer answerPostId, HttpSession session, Model m) {
		Post answer = postServie.selectPostById(answerPostId);
		m.addAttribute("postQuest", postServie.selectPostById(answer.getParentId()));
		User user = (User) session.getAttribute("user");
		if (null != user && null != answer && user.getId() == answer.getOwnerUserId()) {
			try {
				postServie.deletePost(answerPostId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/viewPost.htm?postId=" + answer.getParentId();
	}

	@RequestMapping("deleteQuestion")
	public String deleteQuestion(@RequestParam Integer postQuestId, HttpSession session, Model m) {
		Post post = postServie.selectPostById(postQuestId);
		User user = (User) session.getAttribute("user");
		List<Post> topPosts = null;

		if (null != user && null != post && user.getId() == post.getOwnerUserId()) {
			try {
				postServie.deletePost(postQuestId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		topPosts=postServie.getTopPosts(10);
		m.addAttribute("topPosts", topPosts);
		java.util.List<Post> topPostsUnAnswered=null;
        topPostsUnAnswered = postServie.getTopPostsUnAnswered(10);
        m.addAttribute("topPostsUnAnswered", topPostsUnAnswered);
		m.addAttribute("postCommand", new Post());
		return "home";
	}

	@RequestMapping("searchQuestion")
	public String searchQuestion(Model model,@ModelAttribute("postCommand") Post post,HttpSession session) {
	    User user = (User)session.getAttribute("user");
	    model.addAttribute("searchResultsList", postServie.searchQuestion(post));
	    model.addAttribute("postCommand", new Post());
	    return "searchResults";
	}

	@RequestMapping("yourQuestions")
	public String yourQuestions(Model model, HttpSession session) {
	    User user = (User) session.getAttribute("user");
	    List<Post> topPosts = null;
        List<Post> yourQuestions = null;
        yourQuestions = postServie.getYourQuestions(user.getId());
        topPosts = postServie.getTopPosts(10);
        model.addAttribute("topPosts", topPosts);
        model.addAttribute("yourQuestions", yourQuestions);
        model.addAttribute("postCommand", new Post());
	    return "myQuestions";
	}
}
