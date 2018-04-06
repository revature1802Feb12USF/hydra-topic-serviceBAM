package com.revature.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Subtopic;
import com.revature.model.Topic;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

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

}