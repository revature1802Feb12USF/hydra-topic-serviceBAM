package com.revature.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.revature.beans.Subtopic;

import io.restassured.RestAssured;
import springfox.documentation.spring.web.json.Json;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @author Nguyen
 *
 */
/**
 * @author Nguyen
 *
 */
public class SubTopicControllerTesting {
	@Autowired
	Subtopic subtopic;
	
	/**
	 * Test get subtopic endpoint /subtopic GET Method
	 * assertThat status code = 200 
	 * @author Nicole Nguyen - Batch 1802 - Knighten 
	 */
	@Test
	public void testGetSubtopicsEndpoint() {
	   when().
	       get("http://localhost:8080/subtopics").then().assertThat().
           statusCode(200).
           extract().response();    
	}
	@Test 
	public void testPostSubtopicsEndpoint() {

		String newString = "{\"topicId\": \"5005\",\r\n" + 
				"  \"subtopicName\" : \"Mircorosive\"\r\n" + 
				"}";
		
			//String testString = "{'topicId': 5005," + "\n" + " 'subtopicName' : 'Mircorosive'}";
			given().
			 contentType("application/json")
			 .body(newString)
			   .when().
		       post("http://localhost:8080/subtopics").then().assertThat().
	           statusCode(200).
	           extract().response();   
		
		
	}
	/**
	 * Test get topic endpoint /subtopic/idList?ids= GET Method
	 * assertThat status code = 200 if connection is made
	 * @author Nicole Nguyen - Batch 1802 - Knighten 
	 */
	@Test
	public void testGetcheckListOfIds() {
		   when().
	       get("http://localhost:8080/subtopics/idList?ids=1001,1002").then().assertThat().statusCode(200);
	}
	/**
	 * Test get topic endpoint /subtopic?ids= GET Method
	 * assertThat status code = 200 if connection is made
	 * @author Nicole Nguyen - Batch 1802 - Knighten 
	 */
	@Test
	public void testGetSubtopicsByIds() {
		 when().
	       get("http://localhost:8080/subtopics?ids=1001,1002").then().assertThat().statusCode(200);

	}
}
