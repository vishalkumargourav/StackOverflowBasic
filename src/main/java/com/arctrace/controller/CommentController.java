package com.arctrace.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arctrace.domain.Comment;
import com.arctrace.domain.User;
import com.arctrace.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService commentServie;
	
	@RequestMapping("commentSave")
	public String commentSave(@RequestParam Integer postId,@ModelAttribute("commentCommand") Comment comment, Model m,HttpSession session) {
		User user=(User)session.getAttribute("user");
		comment.setPostId(postId);
		comment.setUserDisplayName(user.getDisplayName());
		comment.setUserId(user.getId());
		try {
			commentServie.insertNewComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/viewPost.htm?postId=" + postId;
	}
}
