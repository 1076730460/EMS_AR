package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Post;
import com.ems.service.PostService;

@Controller
@RequestMapping(value = "/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/post.html")
	public ModelAndView  showPosts(){
		Post post = postService.get("");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postPage/post");
		mv.addObject("post", post);
		return mv;
	}
}
