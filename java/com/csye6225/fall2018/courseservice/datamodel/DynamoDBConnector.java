package com.csye6225.fall2018.courseservice.datamodel;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;


import java.util.HashMap;
import java.util.Map;

public class DynamoDBConnector {

	 static AmazonDynamoDB dynamoDb ;

	 public static void init() {
		if (dynamoDb == null) {
		AWSCredentialsProvider credentialsProvider = new InstanceProfileCredentialsProvider(false);
		
		credentialsProvider.getCredentials();
		
		dynamoDb = AmazonDynamoDBClientBuilder
					.standard()
					.withCredentials(credentialsProvider)
					.withRegion("us-east-2")
					.build();		
		System.out.println("I created the client");
		} 

	}
	 
	 public AmazonDynamoDB getClient() {
		 return dynamoDb;
	 }
}