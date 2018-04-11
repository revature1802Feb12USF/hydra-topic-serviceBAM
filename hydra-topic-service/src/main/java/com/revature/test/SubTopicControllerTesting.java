package com.revature.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Subtopic;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class SubTopicControllerTesting {
	@Autowired
	Subtopic subtopic;
	
	/**
	 * Test get topic endpoint
	 */
	@Test
	public void testGetSubtopicsEndpoint() {
	   when().
	       get("http://localhost:8080/subtopics").then().assertThat().
           statusCode(200).
           extract().response();;	    
	}
}
