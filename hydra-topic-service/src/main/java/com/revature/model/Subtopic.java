package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Bean Class for SubTopic
 * 
 * <ul>
 * <li> subtopicId - int
 * <li> subtopicName - SubtopicName
 * <li> batch - Batch
 * <li> status - SubtopicStatus
 * <li> subtopicDate - Timestamp
 * </ul>
 */
@Entity
@Table(name = "SUBTOPIC")
@Component
public class Subtopic {

	@Id
	@Column(name = "Subtopic_Id")
	@SequenceGenerator(name = "SUBTOPIC_SEQ", sequenceName = "SUBTOPIC_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBTOPIC_SEQ")
	private int subtopicId;

	@Column(name = "Name")
	private String subtopicName;

	@Column(name = "Status")
	private String status;

	@Column(name = "Date")
	private Timestamp date;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENT_TOPIC", referencedColumnName = "TOPIC_ID")
	@Autowired
	private Topic parentTopic;

	

	@Override
	public String toString() {
		return "Subtopic [\n" + "(Subtopic ID) \t subtopicId=" + subtopicId + 
				",\n"
				+ "(Batch ID) \t batch=" + batch + 
				",\n"
				+ "(Subtopic date) \t subtopicDate=" + subtopicDate + 
				",\n"
				+ "(Subtopic status) \t status=" + status +
				"\n"
				+ "]";
	}

}