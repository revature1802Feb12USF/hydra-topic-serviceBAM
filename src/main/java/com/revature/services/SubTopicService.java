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
	 * Adds a subtopic to the database with the given information
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @author Pooja Suresh (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 * @param name - String to give to the new Subtopic object
	 * @param parentTopic - Topic object to have the subtopic refer to
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
	 * @author Samuel Louis-Pierre (Batch Steve 1801)
	 * @author Avant Mathur (Batch Steve 1801)
	 */
	public void updateSubtopic(Subtopic subtopic) {
	    subtopicRepository.save(subtopic);
	}

	/**
	 * Get the status of the subtopic with the given ID
	 * 
	 * @author Unknown
	 * @param subtopicId - int of the id for the subtopic desired
	 * @return the status of the subtopic with the given ID int
	 */
	public String getStatus(int subtopicId) {
		Subtopic subtopic = subtopicRepository.findById(subtopicId).get();
		return subtopic.getStatus();
	}

	/**
	 * Get all the subtopics in the database, and return them
	 * 
	 * @author Pooja Suresh (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 * @param void
	 * @return all subtopic objects in the database as a JSON object
	 */
	public List<Subtopic> getSubtopics() {
		return subtopicRepository.findAll();
	}
	
	/**
	 * Returns whether or not subtopics with all the IDs in the list exist within the database
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param ids - list of ids to search with
	 * @return boolean indicating if every ID in the list exists in the DB
	 */
	public ResponseEntity<?> checkListOfIds(List<Integer> ids){		
		for(Integer i : ids) {
			if(!subtopicRepository.existsBySubtopicId(i)) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Returns all the subtopics objects with the given list of IDs
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param ids - list of ids to search with
	 * @return a ResponseEntity whose HttpStatus and body vary given different conditions:
	 * 	  - all id's present -> HttpStatus.OK, body = JSON list of Subtopic objects that correspond
	 *    - some id's present -> HttpStatus.PARTIAL_CONTENT, body = JSON list of the ones found
	 *    - no id's present -> HttpStatus.NO_CONTENT, body = null
	 *    - something weird happens -> HttpStatus.I_AM_A_TEAPOT, body = null
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
	 * Deletes the subtopic entry with the given id
	 * 
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @param id - Integer of the id to delete
	 * @return void
	 */
	public void deleteSubtopic(Integer id) {
		subtopicRepository.deleteById(id);
	}

	/**
	 * Find the subtopic entry given the name
	 * 
	 * @author Unknown
	 * @param name - String of the name to find the subtopic by
	 * @return Subtopic object with the given name
	 */
	public Subtopic getSubtopicByName(String name) {
		return subtopicRepository.findBySubtopicName(name);
	}

	/**
	 * add or update the subtopic entry with the given entry
	 * 
	 * @author Brian McKalip (Batch Steve 1801)
	 * @param subtopic - Subtopic objects to add or update in the DB
	 * @return void
	 */
	public void addOrUpdateSubtopic(Subtopic subtopic) {
		subtopicRepository.save(subtopic);
	}
}
