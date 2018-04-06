package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Topic;

@Repository
public interface TopicNameRepository extends JpaRepository<Topic, Integer> {
	
	/**
	 * Find all TopicName by id
	 * @param Topicname id
	 * @return TopicName
	 */
	public Topic findByid(Integer id);
}