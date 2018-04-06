package com.revature.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.model.Batch;
import com.revature.model.Topic;
import com.revature.model.TopicWeek;
import com.revature.repository.TopicRepository;
import com.revature.repository.TopicWeekRepository;
@Service
public class TopicService {
 @Autowired
 TopicWeekRepository topicWeekRepository;
 @Autowired
 TopicRepository topicNameRepository;
 /**
  * adds topic to the topics to be covered by a batch, on a certain week
  *
  * @param topicNameId - name id for a new topic object
  * @param batch - batch number for a new topic object
  * @param weekNumber - week number for a new topic object
  */
 public void addTopic(int topicNameId, int batch, int weekNumber) {
  TopicWeek topic = new TopicWeek();
  Topic topicName = topicNameRepository.findByid(topicNameId);
 
  topic.setTopic(topicName);
  topic.setBatch(new Batch(batch));
  topic.setWeekNumber(weekNumber);
 
  topicWeekRepository.save(topic);
 }
 /**
  * get all the topics to be covered by a batch
  *
  * @param batch - Batch to search for topics in
  * @return List<TopicWeek> of the topics for a specific batch
  */
 public List<TopicWeek> getTopicByBatch(Batch batch) {
  return topicWeekRepository.findByBatch(batch);
 }
 /**
  * gets all the topics covered by all batches
  *
  * @return List<TopicName> of all TopicNames in the database
  */
 public List<Topic> getTopics() {
  return topicNameRepository.findAll();
 }
 /**
  * add or update a topic entry with the given topic entry
  *
  * @param topic - TopicName to be stored in the database
  */
 public void addOrUpdateTopicName(Topic topic) {
  topicNameRepository.save(topic);
 }
  
 /**
  * find a topic entry by its id
  *
  * @param id - int to find a specific TopicName with
  * @return the TopicName with the given id number
  */
 public Topic getTopicName(int id) {
  return topicNameRepository.findByid(id);
 } 
}

