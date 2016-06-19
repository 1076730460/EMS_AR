package com.ems.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dao.UserDAO;
import com.ems.entity.User;
/**
 * create time 2016.6.18
 * @author gjp
 *
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public User load(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public User get(String id) {
		// TODO Auto-generated method stub
		return (User)this.getCurrentSession().get(User.class,id);
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public void persist(User entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}
	public String save(User entity) {
		// TODO Auto-generated method stub
		return (String)this.getCurrentSession().save(entity);
	}
	public void saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		
	}
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	public void flush() {
		// TODO Auto-generated method stub
		
	}

}
