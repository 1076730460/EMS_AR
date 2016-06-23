package com.ems.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ems.entity.Post;
import com.ems.entity.TestParper;
import com.ems.entity.Testquestion;
import com.ems.entity.TestquestionType;
import com.ems.service.PostService;
import com.ems.service.TestParperService;
import com.ems.service.TestquestionService;
import com.ems.service.TestquestionTypeService;
import com.ems.utils.RandomNum;

/**
 * create time 2016.6.20
 * 
 * @author gjp
 * 
 */
@Controller
@RequestMapping(value = "/testQuestPage")
public class TestquestionController {
	private static final Logger LOGGER = Logger
			.getLogger(LoginController.class);
	@Autowired
	private TestquestionService testQuestionService;

	@Autowired
	private PostService postService;

	@Autowired
	private TestquestionTypeService typeService;

	@Autowired
	private TestParperService parperService;

	@RequestMapping(value = "/question.html")
	public ModelAndView showQuestions() {
		ModelAndView mv = new ModelAndView();
		List<Testquestion> questionList = testQuestionService.findAll();
		List<Post> posts = postService.findAll();
		List<TestquestionType> typeList = typeService.findAll();
		mv.setViewName("/questionPage/question");
		mv.addObject("questionList", questionList);
		mv.addObject("posts", posts);
		mv.addObject("typeList", typeList);
		mv.addObject("num", questionList.size());
		return mv;
	}

	@RequestMapping(value = "/delet")
	@ResponseBody
	public Map<String, Object> deletQuestion(HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		String id = params.get("id").toString();
		try {
			testQuestionService.delete(id);
			result.put("success", true);
			result.put("message", "删除成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("message", "删除失败！");
		}

		return result;
	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public ModelAndView updateQuestion(HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		ModelAndView mv = new ModelAndView();
		String id = params.get("id").toString();
		try {
			Testquestion question = testQuestionService.get(id);
			System.out.println("---------------->" + question.toString());
			List<Post> posts = postService.findAll();
			List<TestquestionType> typeList = typeService.findAll();
			mv.setViewName("/fragment/questionUpdate");
			mv.addObject("posts", posts);
			mv.addObject("typeList", typeList);
			mv.addObject("question", question);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

		return mv;
	}

	/**
	 * create time 2016.6.21
	 * 
	 * @author gjp
	 * @param request
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/AddQuestion")
	@ResponseBody
	public Map<String, Object> addQuestion(HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String postId = params.get("post").toString();
			String typeId = params.get("questionType").toString();
			Post post = postService.get(postId);
			System.out.println(post.toString());
			TestquestionType type = typeService.get(typeId);
			Testquestion question = new Testquestion();
			question.setId(UUID.randomUUID().toString());
			question.setName(params.get("questionName").toString());
			question.setOptions(params.get("questionOptions").toString());
			question.setRightOption(params.get("RightOption").toString());
			question.setPost(post);
			question.setTestquestionType(type);
			question.setCreate_person("zhangsan");
			question.setCreate_time(new Date());
			String id = testQuestionService.save(question);
			LOGGER.info(JSON.toJSONString(id));
			result.put("success", true);
			result.put("message", "添加成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("message", "添加失败");
		}
		return result;
	}

	/**
	 * @author gjp update question
	 */
	@RequestMapping(value = "/updateOrSave")
	@ResponseBody
	public Map<String, Object> updateOrSaveQuestion(HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String postId = params.get("post").toString();
			String typeId = params.get("questionType").toString();
			String questionId = params.get("questionId").toString();
			Post post = postService.get(postId);
			System.out.println(post.toString());
			TestquestionType type = typeService.get(typeId);
			Testquestion question = new Testquestion();
			question.setId(questionId);
			question.setName(params.get("questionName").toString());
			question.setOptions(params.get("questionOptions").toString());
			question.setRightOption(params.get("RightOption").toString());
			question.setPost(post);
			question.setTestquestionType(type);
			question.setCreate_person("zhangsan");
			question.setCreate_time(new Date());
			testQuestionService.update(question);
			result.put("success", true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("message", "修改失败");
		}
		return result;
	}

	@RequestMapping(value = "/automaticParper")
	@ResponseBody
	public Map<String, Object> automaticParper(HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String postId = params.get("postId").toString();
			String typeId = params.get("typeId").toString();
			String strNum = params.get("questionNum").toString();
			int num = Integer.parseInt(strNum);
			Post post = postService.get(postId);
			TestquestionType type = typeService.get(typeId);
			List<Testquestion> questionList = testQuestionService
					.getSearchQuestion(postId, typeId);
			int index[] = RandomNum.randomCommon(0, questionList.size(), num);
			for (int i=0;i<index.length;i++) {
				/*TestParper parper = new TestParper();
				parper.setId(UUID.randomUUID().toString());
				parper.setName(question.getPost().getName());
				parper.getQuestion().add(question);
				parperService.save(parper);*/
				Testquestion tq = questionList.get(index[i]);
				tq.setLib("1");
				testQuestionService.saveOrUpdate(tq);			
			}
			result.put("success",true );
			result.put("Msg","组卷成功！" );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("errorMsg","数据存储异常！" );
		}

		return result;
	}
}
