package com.revature.test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Topic;

import io.restassured.http.ContentType;


public class TopicControllerTesting {

	@Autowired
	Topic topic;
	
	/**
	 * @author Pooja Suresh
	 * 
	 */
	@Test
	public void addTopicTest() {

		given().
		body("{\"id\":\"2\", "
				+ "\"name\"  ").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:8080/topic");
/*
		when().
	       post("http://localhost:8080/topic").then().assertThat().
	       statusCode(200).
	       extract().response();	*/
	}

	/**
	 * @author Pooja Suresh
	 * 
	 */
	@Test
	public void getAllTopicsTest() {
		
	    when().
	       get("http://localhost:8080/").then().assertThat().
	       statusCode(200).
	       extract().response();
	}
}
