package com.ManyToMany_Mapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="emp_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int e_id;
	@Column(name="emp_name")
	private String ename;
	@Column
	private String department;
	
	@ManyToMany(cascade =CascadeType.MERGE)
	@JoinTable
	private List<Project> projectList = new ArrayList<Project>();

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public Employee(int e_id, String ename, String department, List<Project> projectList) {
		super();
		this.e_id = e_id;
		this.ename = ename;
		this.department = department;
		this.projectList = projectList;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", ename=" + ename + ", department=" + department + ", projectList="
				+ projectList + "]";
	}
		
}
