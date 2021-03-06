package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Topic;
import com.revature.services.TopicService;

/**
 * handles ZUUL endpoint /topics
 * 
 * "/" 	- GET - returns the entire list of Topics
 * 		- POST - takes in a name, inserts a new Topic object into the DB
 * 		- DELETE - takes in an id, deletes the Topic with the id number
 */
@RestController
class TopicController {

	@Autowired
	TopicService topicService;

	/**
	 * Adds a new TopicName to the TopicName table in the database
	 * 
	 * @author Pooja Suresh (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 * @param name
	 *            - String for the name of the topic to be added           
	 */
	@PostMapping("/")
	public void addTopic(@RequestBody String name) {
		Topic topic = new Topic();
		topic.setTopicName(name);
		topicService.addOrUpdateTopic(topic);
	}

	/**
	 * returns all topics in database
	 * 
	 * @author Pooja Suresh (Batch Matt 1802) 
	 * @author Nicole Nguyen (Batch Matt 1802)
	 */
	@GetMapping("/")
	public List<Topic> getAllTopics() {
		return topicService.getTopic();
	}
	
	/**
	 * Delete the topic with the given id number
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param id - Integer - id of the topic to delete
	 */
	@DeleteMapping(value="/", params = "id")
	@ResponseBody
	public void deleteTopic(@RequestParam("id") Integer id) {
		topicService.deleteTopic(id);
	}
}
