package com.ems.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dao.TestquestionTypeDAO;
import com.ems.entity.Testquestion;
import com.ems.entity.TestquestionType;
@Repository("testquestionTypeDAO")
public class TestquestionTypeDAOImpl implements TestquestionTypeDAO{
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public TestquestionType load(String id) {
		// TODO Auto-generated method stub
		return (TestquestionType) this.getCurrentSession().load(TestquestionType.class, id);
	}

	public TestquestionType get(String id) {
		// TODO Auto-generated method stub
		return (TestquestionType) this.getCurrentSession().get(TestquestionType.class, id);
	}

	public List<TestquestionType> findAll() {
		// TODO Auto-generated method stub
		List<TestquestionType> testquestionType = this.getCurrentSession().createQuery("from TestquestionType").setCacheable(true).list();
		return testquestionType;
	}

	public void persist(TestquestionType entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public String save(TestquestionType entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(TestquestionType entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		TestquestionType entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

}
