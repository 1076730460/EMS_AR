package com.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dao.PostDAO;
import com.ems.entity.Post;
import com.ems.service.PostService;
@Service("postService")
public class PostServiceImpl implements PostService{
	@Autowired
	private PostDAO postDAO;
	public String save(Post entity) {
		// TODO Auto-generated method stub
		return postDAO.save(entity);
	}

	public Post load(String id) {
		// TODO Auto-generated method stub
		return postDAO.load(id);
	}

	public Post get(String id) {
		// TODO Auto-generated method stub
		return postDAO.get(id);
	}

	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return postDAO.findAll();
	}

	public void persist(Post entity) {
		// TODO Auto-generated method stub
		postDAO.persist(entity);
	}

	public void saveOrUpdate(Post entity) {
		// TODO Auto-generated method stub
		postDAO.saveOrUpdate(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		postDAO.delete(id);
	}

	public void flush() {
		// TODO Auto-generated method stub
		postDAO.flush();
	}

}
