package com.ems.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ems_testparper",catalog = "ems")
public class TestParper implements java.io.Serializable{
	private String id;
	private String name;
	private Set<Testquestion> question = new HashSet<Testquestion>();
	@Id
	@Column(name = "id",unique = true,nullable = false,length = 36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@ManyToMany(fetch = FetchType.LAZY)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinTable(name = "ems_parper_question", catalog = "ems", joinColumns = { @JoinColumn(name = "parperId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "questionId", nullable = false, updatable = false) })
	public Set<Testquestion> getQuestion() {
		return question;
	}
	public void setQuestion(Set<Testquestion> question) {
		this.question = question;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "TestParper [id=" + id + ", name=" + name + ", question="
				+ question + "]";
	}
	
}
