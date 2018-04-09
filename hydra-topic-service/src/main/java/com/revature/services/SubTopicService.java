package com.revature.services;
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
