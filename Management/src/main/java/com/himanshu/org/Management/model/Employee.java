package com.himanshu.org.Management.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	int eno;
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	String name;
	int salary;
	public Employee(int eno, String name, int salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		
	}
	

}
