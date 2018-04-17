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
	 * 
	 * @param topicName
	 * @author Unknown
	 * @author Pooja Suresh (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 */
	public void addTopic(String topicName) {
		Topic topic = new Topic();
		topic.setTopicName(topicName);
		
		topicRepo.save(topic);
	}
	
	/**
	 * Returns all topics in the database
	 * 
	 * @author Unknown
	 * @param void
	 * @return list of topics in the database
	 */
	public List<Topic> getTopic(){
		return topicRepo.findAll();
	}
	
	/**
	 * This saves or updates Topic object in the database
	 * 
	 * @author Unknown
	 * @param topic object
	 * @return void
	 */
	public void addOrUpdateTopic(Topic topic) {
		topicRepo.save(topic);
	}
	
	/**
	 * This returns a Topic object
	 * 
	 * @author Pooja Suresh (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 * @param topicId - int to find the topic of
	 * @return Topic object that corresponds to the given id
	 */
	public Topic getTopicById(int topicId) {
		return topicRepo.findByTopicID(topicId);
	}
	
	/**
	 * Deletes the topic entry with the given id
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param id - Integer of the id to delete
	 * @return void
	 */
	public void deleteTopic(Integer id) {
		topicRepo.deleteById(id);
	}
}
