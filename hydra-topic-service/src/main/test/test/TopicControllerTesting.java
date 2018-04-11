package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Topic;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TopicControllerTesting {

	@Autowired
	Topic topic;
	
	/**
	 * @author Pooja Suresh
	 * 
	 */
	@Test
	public void addTopicTest() {
		
		when().
	       post("http://localhost:8080/api/v2/Topics/").then().assertThat().and().
	       statusCode(200).
	       extract().response();
	}
	
	@Test
	public void getAllTopicsTest() {
		
	    when().
	       get("http://localhost:8080/api/v2/Topics/").then().assertThat().and().
	       statusCode(200).
	       extract().response();
	}
}
