package com.ems.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ems.entity.Post;
import com.ems.entity.Testquestion;
import com.ems.entity.TestquestionType;
import com.ems.entity.User;

/**
 * create time 2016.618
 * @author gjp
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml",
		"classpath:spring-hibernate.xml"})
public class EmsTest {
	private static final Logger LOGGER = Logger.getLogger(EmsTest.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private TestquestionTypeService typeService;
	
	@Autowired
	private TestquestionService questionService;
	@Test
	public void save(){
		User user = new User();
		user.setUserName("gjp");
		user.setPassword("123456");
		user.setName("张三");
		user.setDeptName("研发部");
		user.setTitle("软件开发工程师");
		user.setCellPhone("15988234526");
		user.setMailAddress("153526527@qq.com");
		String id = userService.save(user);
		LOGGER.info(JSON.toJSONString(id));
	}
	@Test
	public void getUser(){
		User user= userService.getUser("zhangsan");
		user.toString();
	}
	@Test
	public void getPost(){
		Post post = postService.get("5d530f59-3b4b-4b0b-8046-5919fcf87544");
		System.out.println(post.toString());
		
	}
	
	@Test
	public void savePostAndType(){
		Post post = new Post();
		post.setId(UUID.randomUUID().toString());
		post.setName("db");
		post.setCreate_person("张三");
		post.setCreate_time(new Date());
		postService.save(post);
		
		TestquestionType type = new TestquestionType();
		type.setId(UUID.randomUUID().toString());
		type.setName("判断题");
		type.setCreate_person("张三");
		type.setCreate_time(new Date());
		typeService.save(type);
		
		/*Testquestion tq1 = new Testquestion();
		tq1.setId(UUID.randomUUID().toString());
		tq1.setName("方法的定义和常量值的集合是( )");
		tq1.setOptions("A.单元     B.接口     C.成员    D.变量");
		tq1.setRightOption("B");
		tq1.setPost(post);
		tq1.setTestquestionType(type);
		tq1.setCreate_person("张三");
		tq1.setCreate_time(new Date());
		questionService.save(tq1);*/
		
	}
	@Test
	public void saveTestquestion(){
		Post post = postService.load("5d530f59-3b4b-4b0b-8046-5919fcf87544");
		TestquestionType type = typeService.load("e9ddf3d7-1e5f-4fee-98b7-9ec5ca8f160c");
		
		Testquestion tq1 = new Testquestion();
		tq1.setId(UUID.randomUUID().toString());
		tq1.setName("方法的定义和常量值的集合是( )");
		tq1.setOptions("A.单元     B.接口     C.成员    D.变量");
		tq1.setRightOption("B");
		tq1.setPost(post);
		tq1.setTestquestionType(type);
		tq1.setCreate_person("张三");
		tq1.setCreate_time(new Date());
		String id = questionService.save(tq1);
		LOGGER.info(JSON.toJSONString(id));
	}
	@Test
	public void getSearchQuestion(){
		String post = "";
		String type = "e9ddf3d7-1e5f-4fee-98b7-9ec5ca8f160c";
		List<Testquestion> result = questionService.getSearchQuestion(post, type);
		for(int i=0;i<result.size();i++){
			Testquestion question = result.get(i);
			System.out.println(question.toString());
		}
	}
	@Test
	public void deletQuestion(){
		String id = "73ff3419-f4c7-454d-97cb-7fdc0139b5bd";
		questionService.delete(id);
	}
}
