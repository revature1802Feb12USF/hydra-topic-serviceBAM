package com.revature.beans;

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
 * <br>
 * <br>
 * Fields
 * <ul>
 * <li> topicID - int - auto-generated ID number (PK)
 * <li> topicName - String - name of the topic
 * </ul> 
 * 
 * @author Trevor Fortner (Batch Matt 1802)
 */
@Component
@Entity
@Table(name = "TOPIC")
public class Topic {

	@Id
	@Column(name = "Topic_Id")
	@SequenceGenerator(name = "TOPIC_NAME_ID_SEQ", sequenceName = "TOPIC_NAME_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPIC_NAME_ID_SEQ")
	private int topicID;

	@Column(name = "Name")
	private String topicName;
	
	
	public Topic() {
		super();
	}

	public Topic(String topicName) {
		super();
		this.topicName = topicName;
	}

	public Integer getTopicID() {
		return topicID;
	}//NOSONAR


	public void setTopicID(Integer topicID) {
		this.topicID = topicID;
	}//NOSONAR


	public String getTopicName() {
		return topicName;
	}//NOSONAR


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}//NOSONAR


	@Override
	public String toString() {
		return "TopicName [\n" +"(Topic ID) \t topicID = " + topicID + ",\n "
				+ "(Topic name) \t topicName = " + topicName + "]";
	}//NOSONAR

}