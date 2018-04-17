package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Topic;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
	
	/**
	 * Find Topic by TopicID
	 * 
	 * @author Unknown
	 * @param id - Integer to find the topic of
	 * @return Topic object corresponding to the given ID
	 */
	public Topic findByTopicID(Integer id);	
}
