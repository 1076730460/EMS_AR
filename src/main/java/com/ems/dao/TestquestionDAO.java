package com.ems.dao;

import java.util.List;

import com.ems.entity.Post;
import com.ems.entity.Testquestion;
import com.ems.entity.TestquestionType;

public interface TestquestionDAO extends GenericDAO<Testquestion, String>{
	public List<Testquestion> getSearchQuestion(String postId,String typeId);
	public void update(Testquestion entity);
}
