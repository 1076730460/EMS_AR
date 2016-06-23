package com.ems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Testquestion;
import com.ems.service.PostService;
import com.ems.service.TestquestionService;
import com.ems.service.TestquestionTypeService;

@Controller
@RequestMapping(value = "/SearchData")
public class SearchDataController {
	@Autowired
	private PostService postService;

	@Autowired
	private TestquestionTypeService typeService;

	@Autowired
	private TestquestionService testQuestionService;

	@RequestMapping(value = "/questionInfoSearch")
	public ModelAndView questionInfoSearch(HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		ModelAndView mv = new ModelAndView();	
		String postId = params.get("postSelect").toString();
		String typeId = params.get("typeSelect").toString();
		List<Testquestion> questionList = testQuestionService
				.getSearchQuestion(postId, typeId);
		for (int i = 0; i < questionList.size(); i++) {
			Testquestion question = questionList.get(i);
			System.out.println(question.toString());
		}
		mv.setViewName("/fragment/question-list");
		mv.addObject("questionList", questionList);
		mv.addObject("num", questionList.size());
		return mv;
	}
}
