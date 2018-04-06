package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Subtopic;
import com.revature.services.SubTopicService;
import com.revature.services.TopicService;

@RestController
@RequestMapping(value = "/api/v2/Subtopic/")
public class SubTopicController {

	@Autowired
	TopicService topicService;

	@Autowired
	SubTopicService subTopicService;

	/**
	 * What does this even do, like seriously
	 * 
	 * @return new Subtopic
	 */
	@GetMapping("/subTop")
	public Subtopic home() {
		return new Subtopic(null, null, null, null);
	}
}
