package com.ems.service;

import java.util.List;

import com.ems.entity.Testquestion;

public interface TestquestionService {
	Testquestion load(String id);

	Testquestion get(String id);

	List<Testquestion> findAll();

	void persist(Testquestion entity);

	String save(Testquestion entity);

	void saveOrUpdate(Testquestion entity);

	void delete(String id);

	void flush();
}
