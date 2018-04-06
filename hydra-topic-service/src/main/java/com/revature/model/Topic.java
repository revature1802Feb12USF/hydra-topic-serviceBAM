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
 * Bean Class for SubTopic Status
 * 
 * <ul>
 * <li> id (change to topicNameId)
 * <li> name (change to topicName)
 * </ul>
 */
@Component
@Entity
@Table(name = "Topic_Name")
public class Topic {

	@Id
	@Column(name = "Topic_ID")
	@SequenceGenerator(name = "TOPIC_NAME_ID_SEQ", sequenceName = "TOPIC_NAME_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPIC_NAME_ID_SEQ")
	private Integer topicID;

	@Column(name = "Topic_Name")
	private String topicName;

	@Column(name = "Batch_ID")
	private int batchID;
	
	@Column(name = "Week_Number")
	private int weekNumber;
	
	
	public Topic() {
		super();
	}

	public Topic(String topicName, int batchID, int weekNumber) {
		super();
		this.topicName = topicName;
		this.batchID = batchID;
		this.weekNumber = weekNumber;
	}


	public Integer getTopicID() {
		return topicID;
	}


	public void setTopicID(Integer topicID) {
		this.topicID = topicID;
	}


	public String getTopicName() {
		return topicName;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}


	public int getBatchID() {
		return batchID;
	}


	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}


	public int getWeekNumber() {
		return weekNumber;
	}


	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}


	@Override
	public String toString() {
		return "TopicName [\n" +"(Topic ID) \t topicID = " + topicID + ",\n "
				+ "(Topic name) \t topicName = " + topicName + ", \n"
				+ "(Batch ID) \t batchID = " + batchID + ", \n"
				+ "(Week Number) \t weekNumber = " + weekNumber + ", \n"
				+ "]";
	}//NOSONAR

}