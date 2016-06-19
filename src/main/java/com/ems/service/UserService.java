package com.ems.service;

import java.util.Map;

import com.ems.entity.User;

public interface UserService {
	public User getUser(String id);
	public String save(User user);
	public Map<String,Object> login(String userName,String password);
}
