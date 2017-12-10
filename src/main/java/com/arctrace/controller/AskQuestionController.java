package com.arctrace.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arctrace.domain.Post;
import com.arctrace.domain.User;
import com.arctrace.service.PostService;

@Controller
public class AskQuestionController {
	@Autowired
	PostService postServie;

	@RequestMapping("/askQuestionSave")
	public String askQuestion(Model model,@ModelAttribute("postCommand") Post post,HttpSession session){
		Date date = new Date();
		User user = (User)session.getAttribute("user");
		post.setPostTypeId(0);
		post.setOwnerUserId(user.getId());
		post.setOwnerDisplayName(user.getDisplayName());
		post.setLatestEditorUserId(user.getId());
		post.setLatestEditorDisplayName(user.getDisplayName());
		postServie.insertNewPost(post);
		model.addAttribute("topPosts", postServie.getTopPosts(10));
		java.util.List<Post> topPostsUnAnswered=null;
		topPostsUnAnswered = postServie.getTopPostsUnAnswered(10);
        model.addAttribute("topPostsUnAnswered", topPostsUnAnswered);
        model.addAttribute("postCommand", new Post());
		return "home";
	}
}
