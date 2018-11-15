package com.csye6225.fall2018.courseservice.datamodel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="board")
public class Board {
	private String id;
	private String boardId;
	private String courseId;
	
	public Board() {
		
	}
	
	public Board(String boardId, String courseId) {
		this.boardId = boardId;
		this.courseId = courseId;
	}
	
	@DynamoDBAttribute(attributeName="courseid")
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	@DynamoDBIndexHashKey(globalSecondaryIndexName="boardid",attributeName="boardid")
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	
	@DynamoDBHashKey(attributeName="id")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@DynamoDBIgnore
	@Override
	public String toString() { 
		return "BoardId=" + getBoardId() + ", CourseId=" + getCourseId();
	}
}
