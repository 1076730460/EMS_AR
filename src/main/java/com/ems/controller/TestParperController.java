package com.ems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Testquestion;
import com.ems.service.TestParperService;
import com.ems.service.TestquestionService;

@Controller
@RequestMapping(value = "/parperPage")
public class TestParperController {
	private static final Logger LOGGER = Logger
			.getLogger(LoginController.class);
	
	@Autowired
	private TestquestionService testQuestionService;
	
	@Autowired
	private TestParperService parperService;
	@RequestMapping(value = "/parper.html")
	public ModelAndView parper(HttpServletRequest request) {
		String post =  request.getParameter("post");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/parperPage/parper");
		List<Testquestion> questionList = parperService.getParpers(post);
		mv.addObject("questions", questionList);
		mv.addObject("post", post);
		return mv;
	}
}
