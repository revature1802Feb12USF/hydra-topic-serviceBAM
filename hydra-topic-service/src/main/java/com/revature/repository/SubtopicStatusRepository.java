package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.SubtopicStatus;


@Repository
public interface SubtopicStatusRepository extends JpaRepository<SubtopicStatus, Integer> {
	
	/**
	 * Find SubtopicStatus by SubtopicStatus id
	 * @param SubtopicStatusid
	 * @return SubtopicStatus
	 */
	public SubtopicStatus findByid(Integer id);

	/**
	 * Find SubtopicStatus by SubtopicStatus name
	 * @param SubtopicStatusName
	 * @return SubtopicStatus
	 */
	public SubtopicStatus findByName(String name);
}