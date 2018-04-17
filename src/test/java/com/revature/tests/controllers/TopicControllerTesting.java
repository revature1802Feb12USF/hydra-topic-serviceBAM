package com.revature.tests.controllers;

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
		post("http://localhost:9001/api/v2/topics");

	}

	/**
	 * @author Pooja Suresh
	 * 
	 */
	@Test
	public void getAllTopicsTest() {
		
	    when().
	       get("http://localhost:9001/api/v2/topics").then().assertThat().
	       statusCode(200).
	       extract().response();
	}
}
