package com.arctrace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arctrace.domain.User;
import com.arctrace.service.UserService;
import com.arctrace.service.UserServiceInterface;

@Controller
public class SignUpController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/signup")
	public String signUp(Model model) {
		model.addAttribute("userCommand", new User());
		return "signup";
	}

	@RequestMapping(value = "signupSave")
	public String signUpSave(@ModelAttribute("userCommand") User user,Model m) {
		userService.insertNewUser(user);
		return "login";
	}
	
	@RequestMapping(value = "home")
	public String goToHome(Model m){
		return "home";
	}
}
