package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Bean Class for Batch
 * 
 * <ul>
 * <li> id - int (change to batchId)
 * </ul>
 */
@Component
@Entity
@Table(name = "batches")
public class Batch {
	
	@Id
	@Column(name = "Batch_ID")
	@SequenceGenerator(name = "BATCH_ID_SEQ", sequenceName = "BATCH_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_ID_SEQ")
	private int id;

	public Batch() {
		super();
	}

	public Batch(int batchId) {
		super();
		this.id = batchId;
	}

	public int getBatchId() {
		return id;
	}

	public void setBatchId(int batchId) {
		this.id = batchId;
	}

}
