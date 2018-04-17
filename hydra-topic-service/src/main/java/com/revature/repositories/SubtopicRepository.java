package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.beans.Subtopic;
import com.revature.beans.Topic;

@RepositoryRestResource
public interface SubtopicRepository extends JpaRepository<Subtopic, Integer> {
	
	/**
	 * Get the subtopic list that hold a given parent topic
	 * 
	 * @param topic - Topic object that will contain the subtopics returned
	 * @return List of Subtopic objects that correspond to the given Topic objec
	 * @author Trevor Fortner (Batch Matt 1802)
	 * @author Pooja Suresh (Batch Matt 1802)
	 * @author Nicole Nguyen (Batch Matt 1802)
	 * 
	 */
	List<Subtopic> findByParentTopic(Topic parentTopic);

	/**
	 * Counts the number of subtopics in the database by matching it with the given parent topic.
	 * 
	 * @param topic - Topic object that will contain the subtopics counted
	 * @return number of Subtopics
	 * 
	 */
	Long countSubtopicsByParentTopic(Topic topic);
	
	/**
	 * Get the subtopic entry given the name
	 * 
	 * @param name - String of the name to find the subtopic by
	 * @return Subtopic object with the given name
	 * @author Unknown
	 * 
	 */
	Subtopic findBySubtopicName(String name);
	
	/**
	 * Get the subtopic objects with the given IDs
	 * 
	 * @param ids - list of ids to search with
	 * @return list of subtopics with those ids
	 * 
	 */
	List<Subtopic> findBySubtopicIdIn(List<Integer> ids);
  
	/**
	 * Return whether or not a subtopic with the given ID exists in the DB
	 * 
	 * @param ids - list of ids to search with
	 * @return boolean indicating if every ID in the list exists in the DB
	 * 
	 */
	boolean existsBySubtopicId(Integer id);
}