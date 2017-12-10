package com.arctrace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arctrace.domain.Post;
import com.arctrace.domain.User;

@Controller
public class HomeController {
	@RequestMapping(value = "/ask")
	public String adminPage(Model model) {
		model.addAttribute("postCommand", new Post());
		return "ask";
	}
}
