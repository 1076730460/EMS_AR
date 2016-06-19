package com.ems.dao;

import java.io.Serializable;
import java.util.List;

/**
 * create time 2016.6.18
 * @author gjp
 * Dao通用接口
 */

interface GenericDAO<T, PK extends Serializable> {
	
	T load(PK id);
	
	T get(PK id);
	
	List<T> findAll();
	
	void persist(T entity);
	
	PK save(T entity);
	
	void saveOrUpdate(T entity);
	
	void delete(PK id);
	
	void flush();
}
