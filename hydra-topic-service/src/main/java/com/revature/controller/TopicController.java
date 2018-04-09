package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Topic;
import com.revature.services.TopicService;

/**
 * handles ZUUL endpoint /topics
 * 
 * ~~All mappings~~
 */

@RestController
class TopicController {

	@Autowired
	TopicService topicService;

	/**
	 * Adds a new TopicName to the TopicName table in the database
	 * 
	 * @param name
	 *            - String for the name of the topic to be added
	 *            
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
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
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
	 */
	@GetMapping("/")
	public void getAllTopics() {
		
		topicService.getTopic();
	}
}
