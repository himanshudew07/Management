package com.himanshu.org.Management.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Project {
	
	
	public Project() {
		
	}
	public Project(int projectID, String projectName, String description) {		
		this.projectID = projectID;
		this.projectName = projectName;
		this.description = description;
	}
	int projectID;
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	String projectName;
	String description;

}
