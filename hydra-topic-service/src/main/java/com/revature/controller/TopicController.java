package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicType;
import com.revature.model.TopicName;
import com.revature.repository.SubtopicNameRepository;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;


@RestController
@RequestMapping("/api/v2/Topics/")
class TopicController {

	@Autowired
	TopicService topicService;
	
	@Autowired
	SubTopicService subService;

	@Autowired
	SubtopicNameRepository subNameRepo;
	
	
	/**
	 * @return a new TopicName object for when the user reaches each page
	 */
	@GetMapping("/")
	public TopicName home(){
		return new TopicName("New Topic");
	}
	
	/**
	 * @return a JSON containing all the current subtopic names in the database
	 */
	@RequestMapping(value = "/All", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SubtopicName> getAllUsers() {
		return subNameRepo.findAll();
	}

	/**
	 * @param jsonObj - String to represent the json for the Subtopic
	 * 
	 * Adds a subtopic into the subtopic table in the database
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
	 * @param name - String for the name of the topic to be added
	 * 
	 * Adds a new TopicName to the TopicName table in the database
	 */
	@PostMapping("/Add")
	public void addTopicName(@RequestBody String name) {
		TopicName topic = new TopicName();
		topic.setName(name);
		topicService.addOrUpdateTopicName(topic);
	}
	
	/**
	 * @param typeId - 
	 * @param topicId - 
	 * @param subtopicName - 
	 */
	@PostMapping("/addSubtopicName")
	public void addSubTopicName(@RequestBody int typeId, @RequestBody int topicId, @RequestBody String subtopicName) {
		SubtopicType type = subService.getSubtopicType(typeId);
		TopicName topic = topicService.getTopicName(topicId);
		SubtopicName subtopic = new SubtopicName(subtopicName, topic, type);
		subService.addOrUpdateSubtopicName(subtopic);
	}
}
