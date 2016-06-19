package com.ems.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dao.TestquestionDAO;
import com.ems.entity.Testquestion;
@Repository("testquestionDAO")
public class TestquestionDAOImpl implements TestquestionDAO{
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public Testquestion load(String id) {
		// TODO Auto-generated method stub
		return (Testquestion) this.getCurrentSession().load(Testquestion.class, id);
	}

	public Testquestion get(String id) {
		// TODO Auto-generated method stub
		return (Testquestion) this.getCurrentSession().get(Testquestion.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Testquestion> findAll() {
		// TODO Auto-generated method stub
		List<Testquestion> testquestion = this.getCurrentSession().createQuery("from Testquestion").setCacheable(true).list();
		return testquestion;
	}

	public void persist(Testquestion entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public String save(Testquestion entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(Testquestion entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		Testquestion entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

}
