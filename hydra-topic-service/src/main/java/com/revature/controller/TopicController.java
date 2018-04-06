package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Topic;
import com.revature.services.TopicService;

@RestController
@RequestMapping("/api/v2/Topics/")
class TopicController {

	@Autowired
	TopicService topicService;	
	
	/**
	 * Adds a new TopicName to the TopicName table in the database
	 * 
	 * @param name - String for the name of the topic to be added
	 */
	@PostMapping("/topic")
	public void addTopic(@RequestBody String name) {
		Topic topic = new Topic();
		topic.setTopicName(name);
		topicService.addOrUpdateTopic(topic);
	}
}
