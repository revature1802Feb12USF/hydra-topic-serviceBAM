package com.revature.beans;

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
 * <br>
 * <br>
 * Fields
 * <ul>
 * <li> subtopicId - int - auto-generated ID number (PK)
 * <li> subtopicName - String - name of the subtopic
 * <li> status - String - current status of the topic ("Complete", "Not covered", etc)
 * <li> parentTopic - Topic - the topic object that contains this subtopic
 * </ul>
 * 
 * @author Pooja Suresh (Batch Matt 1802)
 * @author Nicole Nyugen (Batch Matt 1802)
 */
@Entity
@Table(name = "SUBTOPIC")
@Component
public class Subtopic {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SUBTOPIC_SEQ", sequenceName = "SUBTOPIC_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBTOPIC_SEQ")
	private int subtopicId;

	@Column(name = "Name")
	private String subtopicName;

	@Column(name = "Status")
	private String status;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENT_TOPIC", referencedColumnName = "Topic_ID")
	@Autowired
	private Topic parentTopic;
	
	
	public Subtopic() {
		super();
	}

	public Subtopic(String subtopicName, String status, Topic parentTopic) {
		super();
		this.subtopicName = subtopicName;
		this.status = status;
		this.parentTopic = parentTopic;
	}

	public int getSubtopicId() {
		return subtopicId;
	}

	public void setSubtopicId(int subtopicId) {
		this.subtopicId = subtopicId;
	}

	public String getSubtopicName() {
		return subtopicName;
	}

	public void setSubtopicName(String subtopicName) {
		this.subtopicName = subtopicName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Topic getParentTopic() {
		return parentTopic;
	}

	public void setParentTopic(Topic parentTopic) {
		this.parentTopic = parentTopic;
	}
	
	@Override
	public String toString() {
		return "Subtopic [\n" 
				+ "(Subtopic ID) \t subtopicId=" + subtopicId + ",\n"
				+ "(Subtopic's Status) \t status=" + status+ ",\n"
				+ "(Subtopic's Name) \t subtopicName=" + subtopicName+ ",\n"
				+ "(Parent topic) \t parentTopic=" + parentTopic.toString() + "]";
	}

}