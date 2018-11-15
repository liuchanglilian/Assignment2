package com.csye6225.fall2018.courseservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.Board;
import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
//import com.csye6225.fall2018.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice.datamodel.Professor;
import com.csye6225.fall2018.courseservice.datamodel.Student;

public class CoursesService{

	static DynamoDBConnector dynamoDb;
	DynamoDBMapper mapper; 
	
	public CoursesService() {
		dynamoDb = new DynamoDBConnector();
		dynamoDb.init();
		mapper = new DynamoDBMapper(dynamoDb.getClient());
	}
	public List<Course> getAllCourses() {	
		//Getting the list
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		List<Course> list = mapper.scan(Course.class, scanExpression);
		return list;
	}
	public Course addCourse(Course cour) {	
		mapper.save(cour);
		return cour;
	}
	public Course getCourse(String courseId) {
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(courseId));
		
		DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<Course>()
				.withIndexName("courseid")
				.withConsistentRead(false)
				.withKeyConditionExpression("courseid = :v1")
				.withExpressionAttributeValues(eav);
		
		List<Course> result = mapper.query(Course.class, queryExpression);
		if(result.size() == 0) return null;
		return result.get(0);
	}
	// Deleting a professor
	public Course deleteCourse(String courseId) {
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(courseId));
		
		DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<Course>()
				.withIndexName("courseid")
				.withConsistentRead(false)
				.withKeyConditionExpression("courseid = :v1")
				.withExpressionAttributeValues(eav);
		
		List<Course> result = mapper.query(Course.class, queryExpression);
		if(result.size() == 0) return null;
		mapper.delete(result.get(0));
		return result.get(0);
	}
	// Updating Professor Info
		public Course updateCourseInformation(String courseId, Course course) {	
			Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
			eav.put(":v1", new AttributeValue().withS(courseId));
			
			DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<Course>()
					.withIndexName("courseid")
					.withConsistentRead(false)
					.withKeyConditionExpression("courseid = :v1")
					.withExpressionAttributeValues(eav);
			
			List<Course> result = mapper.query(Course.class, queryExpression);
			if(result.size() == 0) return null;
			course.setId(result.get(0).getId());
			mapper.save(course);
			return course;
		}
	// Get professors in a department 
	public List<Course> getCoursesByDepartment(String department) {	
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		List<Course> list = mapper.scan(Course.class, scanExpression);

		ArrayList<Course> result = new ArrayList<>();
		for (Course course : list) {
			if (course.getDepartment().equals(department)) {
					result.add(course);
			}
		}
		return result ;
	}
		
}