package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Post;
import com.ems.entity.TestquestionType;
import com.ems.service.PostService;
import com.ems.service.TestquestionService;
import com.ems.service.TestquestionTypeService;
@Controller
@RequestMapping(value = "/homePage")
public class HomeController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private TestquestionTypeService typeService;
	
	@Autowired
	private TestquestionService testQuestionService;
	
	@RequestMapping (value = "/home.html")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView();
		List<Post> posts = postService.findAll();
		List<TestquestionType> typeList = typeService.findAll();
		mv.addObject("posts", posts);
		mv.addObject("typeList", typeList);
		mv.setViewName("/home");
		return mv;
	}
	
}
