package com.ems.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dao.TestParperDAO;
import com.ems.entity.TestParper;
/**
 * create time 2016.6.22
 * @author gjp
 *
 */
@Repository("testParperDAO")
public class TestParperDAOImpl implements TestParperDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public TestParper load(String id) {
		// TODO Auto-generated method stub
		return (TestParper)this.getCurrentSession().load(TestParper.class, id);
	}

	public TestParper get(String id) {
		// TODO Auto-generated method stub
		return (TestParper)this.getCurrentSession().get(TestParper.class, id);
	}

	public List<TestParper> findAll() {
		// TODO Auto-generated method stub
		List<TestParper> testParperList = this.getCurrentSession().createQuery("from TestParper").setCacheable(true).list();
		return testParperList;
	}

	public void persist(TestParper entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
		
	}

	public String save(TestParper entity) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().save(entity).toString();
	}

	public void saveOrUpdate(TestParper entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(id);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

	public List getParpers(String post) {
		// TODO Auto-generated method stub
		Query query = this.getCurrentSession().createQuery("select tq from Testquestion as tq inner join tq.post as p where p.name=:name and tq.lib=1");
		query.setString("name", post);
		return query.list();
	}

}
