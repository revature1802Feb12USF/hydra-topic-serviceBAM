package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Subtopic;
import com.revature.beans.Topic;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

/**
 * 
 * handles ZUUL endpoint /topics
 * 
 * "/subtopics" - GET - returns the list of all subtopics
 * 				- POST - takes in a parent topic ID and a subtopic name, creates new subtopic entry
 * "/subtopics?ids={List<Integer> ids}" - GET
 * 					- returns the list of subtopics that match the ids in the list
 * "/subtopics/idList?{ids}" - GET
 * 				 	- returns a boolean indicating if all the ids exist in the subtopic table
 * 
 * @author Trevor Fortner (Batch Matt 1802)
 */

@RestController

public class SubTopicController {

	@Autowired
	SubTopicService subTopicService;

	@Autowired
	TopicService topicService;

	/**
	 * @author Unknown	
	 * @return a JSON containing all the current subtopic names in the database
	 */
	@GetMapping(value = "/subtopics", produces = "application/json")
	@ResponseBody
	public List<Subtopic> getAllSubtopics() {
		return subTopicService.getSubtopics();
	}

	/**
	 * Adds a new SubtopicName object to the SubtopicName table in the database
	 * 
	 * @author Unknown
	 * @author Trevor (Batch Matt 1802)
	 * @param topicId
	 *            - int to store in a new SubtopicName object as the topic
	 * @param subtopicName
	 *            - String to store in a new SubtopicName object as the name
	 */
	@PostMapping("/subtopics")
	public void addSubtopic(@RequestParam int topicId, @RequestParam String subtopicName) {
		Topic topic = topicService.getTopicById(topicId);
		subTopicService.addSubtopic(subtopicName, topic);
	}
	
	/** 
	 * Returns all the subtopics in a comma-separated list of subtopic ID's
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param - ids - list of id numbers for subtopic objects to check for in the DB
	 * @return ResponseEntity indicating if every ID in the list exists in the DB
	 * 		- all id's present -> HttpStatus.OK, body = null
	 * 		- one or more of the id's missing -> HttpStatus.CONFLICT, body = null
	 */
	@GetMapping(value = "/subtopics/verify", params = "ids")
	@ResponseBody
	public ResponseEntity<?> checkListOfIds(@RequestParam("ids") List<Integer> ids){
		return subTopicService.checkListOfIds(ids);
	}
	
	/** 
	 * Returns all the subtopics in a comma-separated list of subtopic ID's
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 * @param - ids - list of id numbers for subtopic objects to return from the DB
	 * @return a ResponseEntity whose HttpStatus and body vary given different conditions:
	 * 	  - all id's present -> HttpStatus.OK, body = JSON list of Subtopic objects that correspond
	 *    - some id's present -> HttpStatus.PARTIAL_CONTENT, body = JSON list of the ones found
	 *    - no id's present -> HttpStatus.NO_CONTENT, body = null
	 *    - something weird happens -> HttpStatus.I_AM_A_TEAPOT, body = null
	 */
	@GetMapping(value = "/subtopics", params = "ids", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> getSubtopicsByIds(@RequestParam("ids") List<Integer> ids){
		return subTopicService.getSubtopicsByIds(ids);
	}
	
	/**
	 * Delete the subtopic with the given id number
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param id - Integer - id of the subtopic to delete
	 */
	@DeleteMapping(value="/subtopics", params = "id")
	@ResponseBody
	public void deleteSubtopic(@RequestParam("id") Integer id) {
		subTopicService.deleteSubtopic(id);
	}
}
