package com.csye6225.fall2018.courseservice.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName="course")
public class Course {
	private String id;
    private String courseId;	
	private String professorId;
	private String taId;
	private String department;
	private String boardId;
	private List<String> rosters;
	public Course() {
		
	}
	
	public Course(String courseId, String professorId, String taId, String department,String boardId) {
		this.courseId = courseId;
		this.professorId = professorId;
		this.taId = taId;
		this.department = department;
		this.boardId = boardId;
		this.rosters = new ArrayList<>();
	}
	
	@DynamoDBAttribute(attributeName="professorId")
	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}
	
	@DynamoDBAttribute(attributeName="taId")
	public String getTaId() {
		return taId;
	}
	public void setTaId(String taId) {
		this.taId = taId;
	}

	@DynamoDBIndexHashKey(globalSecondaryIndexName="courseid",attributeName="courseid")
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	@DynamoDBHashKey(attributeName="id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@DynamoDBAttribute(attributeName="department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@DynamoDBAttribute(attributeName="boardid")
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	@DynamoDBAttribute(attributeName="rosters")
	public List<String> getRosters() {
		return rosters;
	}
	public void setRosters(List<String> rosters) {
		this.rosters = rosters;
	}
	
	@DynamoDBIgnore
	@Override
	public String toString() { 
		return "CourseId=" + getCourseId() + ", professorId=" + getProfessorId()
				+ ", taId=" + getTaId() + ", department=" + getDepartment()+",boardId"+getBoardId();
	}
}