package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.TestquestionDAO;
import com.ems.entity.Post;
import com.ems.entity.Testquestion;
import com.ems.entity.TestquestionType;
import com.ems.service.TestquestionService;
@Service("testquestionService")
public class TestquestionServiceImpl implements TestquestionService{
	@Autowired
	private TestquestionDAO testQuestionDAO;
	public Testquestion load(String id) {
		// TODO Auto-generated method stub
		return testQuestionDAO.load(id);
	}

	public Testquestion get(String id) {
		// TODO Auto-generated method stub
		return testQuestionDAO.get(id);
	}

	public List<Testquestion> findAll() {
		// TODO Auto-generated method stub
		return testQuestionDAO.findAll();
	}

	public void persist(Testquestion entity) {
		// TODO Auto-generated method stub
		testQuestionDAO.persist(entity);
	}

	public String save(Testquestion entity) {
		// TODO Auto-generated method stub
		return testQuestionDAO.save(entity);
	}

	public void saveOrUpdate(Testquestion entity) {
		// TODO Auto-generated method stub
		testQuestionDAO.saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		testQuestionDAO.delete(id);
	}

	public void flush() {
		// TODO Auto-generated method stub
		testQuestionDAO.flush();
	}

	public List<Testquestion> getSearchQuestion(String postId,String typeId) {
		// TODO Auto-generated method stub
		return testQuestionDAO.getSearchQuestion(postId, typeId);
	}

	public void update(Testquestion entity) {
		// TODO Auto-generated method stub
		testQuestionDAO.update(entity);
	}

}
