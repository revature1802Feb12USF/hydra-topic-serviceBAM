package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Subtopic;
import com.revature.beans.Topic;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

@RestController
public class SubTopicController {

	@Autowired
	SubTopicService subTopicService;

	@Autowired
	TopicService topicService;

	/**
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
	 * @param topicId
	 *            - int to store in a new SubtopicName object as the topic
	 * @param subtopicName
	 *            - String to store in a new SubtopicName object as the name
	 */
	@PostMapping("/subtopic")
	public void addSubtopic(@RequestBody int topicId, @RequestBody String subtopicName) {
		Topic topic = topicService.getTopicById(topicId);
		subTopicService.addSubtopic(subtopicName, topic);
	}
}
