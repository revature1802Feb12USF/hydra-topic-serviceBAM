package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Topic;
import com.revature.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired 
	TopicRepository topicRepo;
	
	/**
	 * This adds a topic to the required topics of a batch
	 * @param topicName
	 * @param batchId
	 * @param weekNumber
	 */
	
	public void addTopic(String topicName, int batchId, int weekNumber) {
		Topic topic = new Topic();
		topic.setTopicName(topicName);
		topic.setBatchID(batchId);
		topic.setWeekNumber(weekNumber);
		
		topicRepo.save(topic);
	}
	/**
	 * Get all topics for a batch
	 * @param batchId
	 * @return list of topics for that 1 batch
	 */
	public List<Topic> getTopicByBatch(int batchId) {
		return topicRepo.findByBatchID(batchId);
	}
	/**
	 * Returns all topics in the database
	 * @return list of topics in the database
	 */
	public List<Topic> getTopic(){
		return topicRepo.findAll();
	}
	/**
	 * This saves or updates Topic object in the database
	 * @param topic object
	 */
	public void addOrUpdateTopicName(Topic topic) {
		topicRepo.save(topic);
	}
	/**
	 * This returns a Topic object
	 * @param topicId
	 * @return a topic
	 */
	public Topic getTopicName(int topicId) {
		return topicRepo.findById(topicId);
	}
}
