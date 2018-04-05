package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Batch;
import com.revature.model.TopicWeek;


@Repository
public interface TopicWeekRepository extends JpaRepository<TopicWeek, Integer> {
	
	/**
	 * Find all TopicWeek by batch object
	 * @param Batch
	 * @return list of TopicWeek
	 */
	List<TopicWeek> findByBatch(Batch batch);
}