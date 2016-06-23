package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.TestParperDAO;
import com.ems.entity.TestParper;
import com.ems.service.TestParperService;
@Service("testParperService")
public class TestParperServiceImpl implements TestParperService{
	@Autowired
	private TestParperDAO testParperDAO;
	public List<TestParper> findAll() {
		// TODO Auto-generated method stub
		return testParperDAO.findAll();
	}
	public String save(TestParper entity) {
		// TODO Auto-generated method stub
		return testParperDAO.save(entity);
	}
	public TestParper get(String id) {
		// TODO Auto-generated method stub
		return testParperDAO.get(id);
	}
	public void saveOrUpdate(TestParper entity) {
		// TODO Auto-generated method stub
		testParperDAO.saveOrUpdate(entity);
	}
	public List getParpers(String post) {
		// TODO Auto-generated method stub
		return testParperDAO.getParpers(post);
	}
	
}
