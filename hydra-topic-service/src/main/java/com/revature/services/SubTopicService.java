package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	 * @author Trevor Fortner, Pooja Suresh, Nicole Nguyen - Batch Matt 1802
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
	 * @author Samuel Louis-Pierre, Avant Mathur - Batch 1801
	 */
	public void updateSubtopic(Subtopic subtopic) {
	    subtopicRepository.save(subtopic);
	}

	/**
	 * 
	 * @param subtopicId
	 * @return
	 */
	public String getStatus(int subtopicId) {
		Subtopic subtopic = subtopicRepository.findById(subtopicId).get();
		return subtopic.getStatus();
	}

	/**
	 * 
	 * @return
	 * @author Pooja Suresh, Nicole Nguyen - Batch Matt 1802
	 */
	public List<Subtopic> getSubtopics() {
		return subtopicRepository.findAll();
	}
	
	/**
	 * @param ids - list of ids to search with
	 * 
	 * @return boolean indicating if every ID in the list exists in the DB
	 * @author Trevor Fortner- Batch Matt 1802
	 */
	public boolean checkListOfIds(List<Integer> ids){		
		for(Integer i : ids) {
			if(!subtopicRepository.existsBySubtopicId(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param ids - list of ids to search with
	 * 
	 * @return list of subtopics with those ids
	 * @author Trevor Fortner - Batch Matt 1802
	 */
	public ResponseEntity<?> getSubtopicsByIds(List<Integer> ids){	
		List<Subtopic> subtopicsFound = subtopicRepository.findBySubtopicIdIn(ids);
		
		if(subtopicsFound.size() == ids.size()) {
			return ResponseEntity.status(HttpStatus.OK).body(subtopicsFound);
		}
		else if(subtopicsFound.size() == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		else if(subtopicsFound.size() < ids.size()) {
			return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(subtopicsFound);
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(null);
	}

	/**
	 * find the subtopic entry given the name
	 * 
	 * @param String
	 *            name
	 * @return SubtopicName
	 * @author Trevor Fortner - Batch Matt 1802
	 */
	public Subtopic getSubtopicByName(String name) {
		return subtopicRepository.findBySubtopicName(name);
	}

	/**
	 * add or update the subtopic entry with the given entry
	 * 
	 * @param SubtopicName
	 *            subtopicName
	 * @author Brian McKalip - Batch 1801
	 */
	public void addOrUpdateSubtopic(Subtopic subtopic) {
		subtopicRepository.save(subtopic);
	}
}
