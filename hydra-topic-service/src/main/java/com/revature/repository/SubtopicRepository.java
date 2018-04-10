package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.revature.beans.Subtopic;
import com.revature.beans.Topic;

@RepositoryRestResource
public interface SubtopicRepository extends JpaRepository<Subtopic, Integer> {
	
	/**
	 * Finds the subtopic list from a given parent topics
	 * 
	 * @param topic - Topic object that will contain the subtopics returned
	 * @return number of Subtopics
	 */
	List<Subtopic> findByParentTopic(Topic parentTopic);

	/**
	 * Counts the number of subtopics in the database by matching it with the given parent topic.
	 * 
	 * @param topic - Topic object that will contain the subtopics counted
	 * @return number of Subtopics
	 */
	Long countSubtopicsByParentTopic(Topic topic);

	Subtopic findBySubtopicName(String name);
	
	/**
	 * @param ids - list of ids to search with
	 * 
	 * @return list of subtopics with those ids
	 */
	List<Subtopic> findBySubtopicIdIn(List<Integer> ids);
	
	/**
	 * @param ids - list of ids to search with
	 * 
	 * @return boolean indicating if every ID in the list exists in the DB
	 */
	boolean existsBySubtopicId(Integer id);
}