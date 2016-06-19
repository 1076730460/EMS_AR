package com.ems.service;

import java.util.List;

import com.ems.entity.TestquestionType;

public interface TestquestionTypeService {
	TestquestionType load(String id);

	TestquestionType get(String id);

	List<TestquestionType> findAll();

	void persist(TestquestionType entity);

	String save(TestquestionType entity);

	void saveOrUpdate(TestquestionType entity);

	void delete(String id);

	void flush();
}
