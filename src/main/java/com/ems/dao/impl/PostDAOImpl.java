package com.ems.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.dao.PostDAO;
import com.ems.entity.Post;
@Repository("postDAO")
public class PostDAOImpl implements PostDAO{
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public Post load(String id) {
		// TODO Auto-generated method stub
		return (Post)this.getCurrentSession().load(Post.class, id);
	}

	public Post get(String id) {
		// TODO Auto-generated method stub
		return (Post)this.getCurrentSession().get(Post.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		List <Post> posts = this.getCurrentSession().createQuery("from Post").setCacheable(true).list();
		return posts;
	}

	public void persist(Post entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	public String save(Post entity) {
		// TODO Auto-generated method stub
		return (String) this.getCurrentSession().save(entity);
	}

	public void saveOrUpdate(Post entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		Post entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

}
