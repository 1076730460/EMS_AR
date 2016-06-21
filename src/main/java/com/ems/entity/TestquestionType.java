package com.ems.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ems_testQuestionType", catalog = "ems")
public class TestquestionType implements java.io.Serializable{
	private String id;
	private String name;
	private String create_person;
	private Date create_time;
	private String update_person;
	private Date update_time;
	private Set<Testquestion> testQuestions = new HashSet<Testquestion>(0);

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreate_person() {
		return create_person;
	}

	public void setCreate_person(String create_person) {
		this.create_person = create_person;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_person() {
		return update_person;
	}

	public void setUpdate_person(String update_person) {
		this.update_person = update_person;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "testquestionType")
	//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public Set<Testquestion> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Set<Testquestion> testQuestions) {
		this.testQuestions = testQuestions;
	}

	@Override
	public String toString() {
		return "TestquestionType [id=" + id + ", name=" + name
				+ ", create_person=" + create_person + ", create_time="
				+ create_time + ", update_person=" + update_person
				+ ", update_time=" + update_time + "]";
	}
}
