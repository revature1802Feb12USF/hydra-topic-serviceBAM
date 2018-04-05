package com.revature.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.revature.model.SubtopicName;

@RepositoryRestResource
public interface SubtopicNameRepository extends JpaRepository<SubtopicName, Integer> {
	
	/**
	 * Find SubtopicName by id
	 * @param Subtopic id
	 * @return SubtopicName
	 */
	public SubtopicName findByid(Integer id);
	
	/**
	 * Find SubtopicName by name
	 * @param Subtopic name
	 * @return SubtopicName
	 */
	public SubtopicName findByName(String name);
	
	/**
	 * Find all SubtopicName in the database
	 * @return list of SubtopicName
	 */
	public List<SubtopicName> findAll();
}
