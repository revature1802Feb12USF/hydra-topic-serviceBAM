package com.revature.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Subtopic;
import com.revature.beans.Topic;
import com.revature.repository.SubtopicRepository;
import com.revature.repository.TopicRepository;

@Service
public class SubTopicService {

	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	SubtopicRepository subtopicRepository;

	/**
	 * adds a subtopic to the list of topics to be reviewed for a batch, with the
	 * given id
	 * 
	 * @param subtopic
	 * @param batch
	 */
	public void addSubtopic(String name, Topic parentTopic) {
		Subtopic newSubtopic = new Subtopic();
		String newStatus = "Not covered";
		
		newSubtopic.setSubtopicName(name);
		newSubtopic.setStatus(newStatus);
		newSubtopic.setParentTopic(parentTopic);	
		
	    subtopicRepository.save(newSubtopic);
	}

	/**
	 * lists out the subtopics to be covered by a batch
	 * 
	 * @param batchId - batch to get all subtopics for
	 * @return List<Subtopic>
	 */
//	public List<Subtopic> getSubtopicByBatch(int batchId) {
//		List<Topic> topicsWithBatchId = topicRepository.findByBatchID(batchId);
//		List<Subtopic> subsInBatch = new ArrayList<Subtopic>();
//		for(Topic t : topicsWithBatchId) {
//			subsInBatch.addAll(subtopicRepository.findByParentTopic(t));
//		}
//		return subsInBatch;
//	}

	/**
	 * 
	 * @param subtopic
	 *            Persisting subtopic to database. To handle timezone offset, before
	 *            submission to DB, adding offset to date and updating date.
	 * 
	 * @author Samuel Louis-Pierre, Avant Mathur
	 */
	public void updateSubtopic(Subtopic subtopic) {
	    subtopicRepository.save(subtopic);
	}

	public String getStatus(int subtopicId) {
		Subtopic subtopic = subtopicRepository.findById(subtopicId).get();
		return subtopic.getStatus();
	}

	/**
	 * Service method to return the number of Subtopics by matching their ids with
	 * the batchId.
	 * 
	 * @param batchId(int)
	 * @return number(long) of Subtopics
	 * 
	 * @author Michael Garza, Gary LaMountain
	 */
//	public Long getNumberOfSubtopics(int batchId) {
//		List<Topic> topicsWithBatchId = topicRepository.findByBatchID(batchId);
//		Long numSubsInBatch = 0L;
//		for(Topic t : topicsWithBatchId) {
//			numSubsInBatch += subtopicRepository.findByParentTopic(t).size();
//		}
//		return numSubsInBatch;
//	}

	public List<Subtopic> getSubtopics() {
		return subtopicRepository.findAll();
	}
	
	
	/**
	 * @param ids - list of ids to search with
	 * 
	 * @return list of subtopics with those ids
	 */
	public List<Subtopic> getSubtopicsByIds(List<Integer> ids){		
		return subtopicRepository.findBySubtopicIdIn(ids); 
	}

	/**
	 * find the subtopic entry given the name
	 * 
	 * @param String
	 *            name
	 * @return SubtopicName
	 */
	public Subtopic getSubtopicByName(String name) {
		return subtopicRepository.findBySubtopicName(name);
	}

	/**
	 * add or update the subtopic entry with the given entry
	 * 
	 * @param SubtopicName
	 *            subtopicName
	 * @author Brian McKalip
	 */
	public void addOrUpdateSubtopic(Subtopic subtopic) {
		subtopicRepository.save(subtopic);
	}
}
