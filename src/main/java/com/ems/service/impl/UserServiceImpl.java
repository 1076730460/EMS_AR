package com.ems.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.utils.HttpServletUtil;
import com.ems.dao.UserDAO;
import com.ems.entity.User;
import com.ems.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return this.userDAO.get(id);
	}
	public String save(User user) {
		// TODO Auto-generated method stub
		return this.userDAO.save(user);
	}
	public Map<String, Object> login(String userName, String password) {
		// TODO Auto-generated method stub
		Map<String,Object> result = new HashMap<String,Object>();
		boolean b = false;
		String message = "";
		User user = getUser(userName);
		if(user != null){
			//user exist
			if(user.getPassword().equals(password)){
				//login success
				 b = true;
				 result.put("success", b);
				 //存 session
				 HttpServletUtil.getInstance().getSession().setAttribute("currentUser", user);
			}else{
				//login failure
				message = "密码错误";
				result.put("message", message);
			}
		}else{
			message = "用户名不存在";
			result.put("message", message);
		}
		return result;
	}

}
