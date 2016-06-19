package com.ems.service;

import java.util.List;
import com.ems.entity.Post;

public interface PostService {
	public String save(Post Entity);
	
	public Post load(String id);

	public Post get(String id);

	public List<Post> findAll();

	public void persist(Post entity);
	
	public void saveOrUpdate(Post entity);

	public void delete(String id);

	public void flush();
}
