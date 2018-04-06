package com.revature.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Subtopic;
import com.revature.beans.Topic;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

@RestController
@RequestMapping(value = "/api/v2/Subtopic/")
public class SubTopicController {

	@Autowired
	SubTopicService subTopicService;
	
	@Autowired
	TopicService topicService;

	/**
	 * @return a JSON containing all the current subtopic names in the database
	 */
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Subtopic> getAllSubtopics() {
		return subTopicService.getSubtopics();
	}

	/**
	 * Adds a subtopic into the subtopic table in the database
	 * 
	 * @param jsonObj - String to represent the json for the Subtopic
	 */
	@PostMapping("/addSubtopic")
	public void addSubtopic(@RequestBody String jsonObj) {
		Subtopic subtopic = null;
		try {
			subtopic = new ObjectMapper().readValue(jsonObj, Subtopic.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		subTopicService.updateSubtopic(subtopic);
	}

	/**
	 * Adds a new SubtopicName object to the SubtopicName table in the database
	 * 
	 * @param typeId - int to store in a new SubtopicName object as the type
	 * @param topicId - int to store in a new SubtopicName object as the topic
	 * @param subtopicName - String to store in a new SubtopicName object as the name
	 */
	@PostMapping("/addSubtopicName")
	public void addSubtopic(@RequestBody int typeId, @RequestBody int topicId, @RequestBody String subtopicName) {
		
		Topic topic = topicService.getTopicById(topicId);
		subTopicService.addSubtopic(subtopicName, topic);
	}
}
