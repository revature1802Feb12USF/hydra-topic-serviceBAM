package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Batch;
import com.revature.model.TopicName;
import com.revature.model.TopicWeek;
import com.revature.repository.TopicNameRepository;
import com.revature.repository.TopicWeekRepository;

@Service
public class TopicService {

	  @Autowired
	  TopicWeekRepository topicWeekRepository;

	  @Autowired
	  TopicNameRepository topicNameRepository;

	  /**
	   * adds topic to the topics to be covered by a batch, on a certain week
	   * 
	   * @param topicNameId
	   * @param batch
	   * @param weekNumber
	   */
	  public void addTopic(int topicNameId, int batch, int weekNumber) {
	    TopicWeek topic = new TopicWeek();
	    Batch b;
	    TopicName topicName;

	    topicName = topicNameRepository.findByid(topicNameId);

	    topic.setTopic(topicName);
	    topic.setWeekNumber(weekNumber);

	    topicWeekRepository.save(topic);
	  }

	  /**
	   * get all the topics to be covered by a batch
	   * 
	   * @param batch
	   * @return
	   */
	  public List<TopicWeek> getTopicByBatch(Batch batch) {
	    return topicWeekRepository.findByBatch(batch);
	  }

	  /**
	   * gets all the topics covered by all batches
	   * 
	   * @return List<TopicName>
	   */
	  public List<TopicName> getTopics() {
	    return topicNameRepository.findAll();
	  }

	  /**
	   * add or update a topic entry with the given topic entry
	   * 
	   * @param topic
	   */
	  public void addOrUpdateTopicName(TopicName topic) {
	    topicNameRepository.save(topic);
	  }
	  
	  /**
	   * find a topic entry by its id
	   * 
	   * @param id
	   * @return
	   */
	  public TopicName getTopicName(int id) {
	    return topicNameRepository.findByid(id);
	  }	
}
