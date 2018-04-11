package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Topic;
import com.revature.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired 
	TopicRepository topicRepo;
	
	/**
	 * This adds a topic to the required topics of a batch
	 * @param topicName
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
	 */
	public void addTopic(String topicName) {
		Topic topic = new Topic();
		topic.setTopicName(topicName);
		
		topicRepo.save(topic);
	}
	
	/**
	 * Returns all topics in the database
	 * @return list of topics in the database
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
	 */
	public List<Topic> getTopic(){
		return topicRepo.findAll();
	}
	
	/**
	 * This saves or updates Topic object in the database
	 * @param topic object
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
	 */
	public void addOrUpdateTopic(Topic topic) {
		topicRepo.save(topic);
	}
	
	/**
	 * This returns a Topic object
	 * @param topicId
	 * @return a topic
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
	 */
	public Topic getTopicById(int topicId) {
		return topicRepo.findByTopicID(topicId);
	}
}
