package com.ems.dao;

import java.util.List;

import com.ems.entity.TestParper;

public interface TestParperDAO extends GenericDAO<TestParper, String>{
	public List getParpers(String post);
}
