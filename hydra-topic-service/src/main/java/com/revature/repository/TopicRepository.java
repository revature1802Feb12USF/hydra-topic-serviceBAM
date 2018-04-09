package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Topic;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	/**
	 * Find Topic by TopicID
	 * @param TopicId
	 * @return Topic
	 */
	public Topic findByTopicID(int id);	
}
