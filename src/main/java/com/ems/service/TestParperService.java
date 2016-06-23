package com.ems.service;

import java.util.List;

import com.ems.entity.TestParper;

public interface TestParperService {
	public List<TestParper> findAll();
	public String save(TestParper entity);
	public TestParper get(String id);
	public void saveOrUpdate(TestParper entity);
	public List getParpers(String post);
}
