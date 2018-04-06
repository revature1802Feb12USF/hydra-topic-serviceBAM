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
	 * Finds the subtopic list by parent topics
	 * 
	 * @param batchId
	 * @return number of Subtopics
	 */
	List<Subtopic> findByParentTopic(Topic parentTopic);

	/**
	 * Counts the number of subtopics in the database by matching it with the
	 * batchid.
	 * @param batchId
	 * @return number of Subtopics
	 */
	Long countSubtopicsByBatchId(int batchId);
	
	/**
	 * Generate a list of Subtopics by a Batch object and a specific
	 * page from a Pageable object.
	 * @param batch
	 * @param pageable
	 * @return list of Subtopics
	 * @author  Michael Garza, Gary LaMountain
	 */
	List<Subtopic> findByBatch(Batch batch, Pageable pageable);

}