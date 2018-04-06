package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Topic;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	/**
	 * Find Topic by TopicID
	 * @param TopicId
	 * @return Topic
	 */
	public Topic findOne(Integer id);	
	/**
	 * @param batchId
	 * @return list of Topic for a batch
	 */
	public List<Topic> findByBatchID(int batchId);
	
	
	
}
