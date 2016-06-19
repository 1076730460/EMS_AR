package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.TestquestionTypeDAO;
import com.ems.entity.TestquestionType;
import com.ems.service.TestquestionTypeService;
@Service("testquestionTypeService")
public class TestquestionTypeServiceImpl implements TestquestionTypeService{
	@Autowired
	private TestquestionTypeDAO typeDAO;
	public TestquestionType load(String id) {
		// TODO Auto-generated method stub
		return typeDAO.load(id);
	}

	public TestquestionType get(String id) {
		// TODO Auto-generated method stub
		return typeDAO.get(id);
	}

	public List<TestquestionType> findAll() {
		// TODO Auto-generated method stub
		return typeDAO.findAll();
	}

	public void persist(TestquestionType entity) {
		// TODO Auto-generated method stub
		typeDAO.persist(entity);
	}

	public String save(TestquestionType entity) {
		// TODO Auto-generated method stub
		return typeDAO.save(entity);
	}

	public void saveOrUpdate(TestquestionType entity) {
		// TODO Auto-generated method stub
		typeDAO.saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		typeDAO.delete(id);
	}

	public void flush() {
		// TODO Auto-generated method stub
		typeDAO.flush();
	}

}
