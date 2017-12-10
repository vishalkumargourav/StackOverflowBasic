package com.arctrace.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arctrace.domain.Post;
import com.arctrace.domain.User;
import com.arctrace.service.PostService;
import com.arctrace.service.UserService;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @RequestMapping(value = { "/", "/welcome**", "/login**" }, method = RequestMethod.GET)
    public String dologin(Model model) {
        model.addAttribute("userCommand", new User());
        return "login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(@ModelAttribute("userCommand") User user, Model model, HttpSession session) {
        String email = user.getEmailHash();
        String password = user.getPassword();
        List<Post> topPosts = null;
        List<Post> topPostsUnAnswered = null;

        User u = userService.selectUser(email, password);
        if (null != u && u.getId() > 0) {
            session.setAttribute("user", u);
            topPosts = postService.getTopPosts(10);
            topPostsUnAnswered = postService.getTopPostsUnAnswered(10);
            model.addAttribute("topPosts", topPosts);
            model.addAttribute("topPostsUnAnswered", topPostsUnAnswered);
            model.addAttribute("postCommand", new Post());
            return "home";
        }
        model.addAttribute("credError", "Username or password incorrect!");
        return "/login";
    }

    @RequestMapping("backHome")
    public String backHome(Model model, HttpSession session) {
        List<Post> topPosts = null;
        List<Post> topPostsUnAnswered = null;
        User user = (User) session.getAttribute("user");
        if (null != user && user.getId() > 0) {
            topPosts = postService.getTopPosts(10);
            topPostsUnAnswered = postService.getTopPostsUnAnswered(10);
            model.addAttribute("topPosts", topPosts);
            model.addAttribute("topPostsUnAnswered", topPostsUnAnswered);
            model.addAttribute("postCommand", new Post());
            return "home";
        }
        return "/login";
    }
}
