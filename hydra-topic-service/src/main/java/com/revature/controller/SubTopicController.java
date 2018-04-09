package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Trevor Fortner
 * handles ZUUL endpoint /topics
 * 
 * "/subtopics" - GET - returns the list of all subtopics
 * "/subtopics" - POST - takes in a parent topic ID and a subtopic name, creates new subtopic entry
 * "/subtopics/multiple{ids}" - GET - returns the list of subtopics that match the ids in the list
 */

@RestController
public class SubTopicController {

	@Autowired
	SubTopicService subTopicService;

	@Autowired
	TopicService topicService;

	/**
	 * @return a JSON containing all the current subtopic names in the database
	 * @author Trevor Fortner - Batch Matt 1802
	 */
	@GetMapping(value = "/subtopics", produces = "application/json")
	@ResponseBody
	public List<Subtopic> getAllSubtopics() {
		return subTopicService.getSubtopics();
	}

	/**
	 * Adds a new SubtopicName object to the SubtopicName table in the database
	 * 
	 * @param topicId
	 *            - int to store in a new SubtopicName object as the topic
	 * @param subtopicName
	 *            - String to store in a new SubtopicName object as the name
	 * @author Trevor Fortner - Batch Matt 1802
	 */
	@PostMapping("/subtopics")
	public void addSubtopic(@RequestBody int topicId, @RequestBody String subtopicName) {
		Topic topic = topicService.getTopicById(topicId);
		subTopicService.addSubtopic(subtopicName, topic);
	}
	
	/** 
	 * Returns all the subtopics in a comma-separated list of subtopic ID's
	 * 
	 * @return a JSON containing all the subtopics with the ID's in the url
	 * 
	 * @author Batch 1802 - Trevor Fortner, Nicole Nguyen
	 */
	@GetMapping(value = "/subtopics/multiple", produces = "application/json")
	@ResponseBody
	public List<Subtopic> getSubtopicsByIds(@RequestParam("ids") List<Integer> ids){
		return subTopicService.getSubtopicsByIds(ids);
	}
}
