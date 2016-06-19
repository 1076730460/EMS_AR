package com.ems.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.User;
import com.ems.service.EmsTest;
import com.ems.service.UserService;
import com.ems.service.impl.UserServiceImpl;
@Controller
public class LoginController {
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
	@RequestMapping (value = "/login.html")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		return mv;
	}
	@RequestMapping("/loginIn")
	@ResponseBody
	public Map<String, Object> loginIn(HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody Map<String, Object> params) {
		String userName = params.get("username").toString();
		String password = params.get("password").toString();
		Map<String, Object> result = userService.login(userName, password);
		// 记录日志
		LOGGER.debug("TEST");
		return result;
	}
}
