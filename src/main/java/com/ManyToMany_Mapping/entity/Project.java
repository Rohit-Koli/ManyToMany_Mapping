package com.ManyToMany_Mapping.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projecttbl")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int project_id;
	@Column
	private String project_name;
	@Column
	private String project_domain;
	
	@ManyToMany(mappedBy = "projectList")	
	private List<Employee> emps = new ArrayList<Employee>();

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_domain() {
		return project_domain;
	}

	public void setProject_domain(String project_domain) {
		this.project_domain = project_domain;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	public Project(int project_id, String project_name, String project_domain, List<Employee> emps) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_domain = project_domain;
		this.emps = emps;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_name=" + project_name + ", project_domain="
				+ project_domain + ", emps=" + emps + "]";
	}
}
