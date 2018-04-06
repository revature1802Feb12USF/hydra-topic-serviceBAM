package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {

	/**
	 * Find batch by id
	 * 
	 * @param batch
	 *            id
	 * @return batch by id
	 */
	// public Batch findByid(Integer id);

}
