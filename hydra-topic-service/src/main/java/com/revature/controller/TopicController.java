package com.revature.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicType;
import com.revature.model.Topic;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

@RestController
@RequestMapping("/api/v2/Topics/")
class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	SubTopicService subService;

//	@Autowired
//	SubtopicNameRepository subNameRepo;
	
	
	/**
	 * @return a new TopicName object for when the user reaches each page
	 */
	@GetMapping("/")
	public Topic home(){
		return new Topic("New Topic", -1, -1);
	}
	
	/**
	 * @return a JSON containing all the current subtopic names in the database
	 */
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Subtopic> getAllSubtopics() {
		return subService.getSubtopics();
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

		subService.updateSubtopic(subtopic);
	}
	
	/**
	 * Adds a new TopicName to the TopicName table in the database
	 * 
	 * @param name - String for the name of the topic to be added
	 */
	@PostMapping("/Add")
	public void addTopicName(@RequestBody String name) {
		
		Topic topic = new Topic();
		topic.setTopicName(name);
		topicService.addOrUpdateTopicName(topic);
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
		
		SubtopicType type = subService.getSubtopicType(typeId);
		Topic topic = topicService.getTopicName(topicId);
//		Subtopic(subtopicName, status, date, topic);
		Subtopic subtopic = new Subtopic("new sub", "open", new Timestamp(System.currentTimeMillis()), new Topic("New topic", -1, -1));
		subService.addOrUpdateSubtopic(subtopic);
	}
}
