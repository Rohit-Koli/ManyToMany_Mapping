package com.ManyToMany_Mapping.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ManyToMany_Mapping.entity.Employee;
import com.ManyToMany_Mapping.entity.Project;

public class Main {
	public static void main(String[] args) {
		insert();
	}
	public static void insert() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory fact = con.buildSessionFactory();
		Session session =fact.openSession();
		Transaction tr = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setE_id(101);
		e1.setEname("Rohit");
		e1.setDepartment("Development");
		e1.setProjectList(null);
		
		Employee e2 = new Employee();
		e2.setE_id(102);
		e2.setEname("Meghraj");
		e2.setDepartment("Developemt");
		e2.setProjectList(null);
		
		Employee e3 = new Employee();
		e2.setE_id(103);
		e2.setEname("Tushar");
		e2.setDepartment("Q&A");
		e2.setProjectList(null);
		
		Project p1 = new Project();
		p1.setProject_id(601);
		p1.setProject_name("Bank Management");
		p1.setProject_domain("Banking");
		p1.setEmps(null);
		
		Project p2 = new Project();
		p2.setProject_id(602);
		p2.setProject_name("Web Development");
		p2.setProject_domain("Management");
		p2.setEmps(null);
		
		Project p3 = new Project();
		p3.setProject_id(603);
		p3.setProject_name("Development");
		p3.setProject_domain("Medical");
		p3.setEmps(null);
		
		List<Project> p = new ArrayList<Project>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		
		List<Employee> e = new ArrayList<Employee>();
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		
		e1.setProjectList(p);
		e2.setProjectList(p);
		e3.setProjectList(p);
		
		p1.setEmps(e);
		p2.setEmps(e);
		p3.setEmps(e);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		tr.commit();
		session.close();
		fact.close();		
	}
	public static void update() {
		
	}
}
