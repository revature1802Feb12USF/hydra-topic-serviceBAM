package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.TopicName;


@Repository
public interface TopicNameRepository extends JpaRepository<TopicName, Integer> {
	
	/**
	 * Find all TopicName by id
	 * @param Topicname id
	 * @return TopicName
	 */
	public TopicName findByid(Integer id);
}