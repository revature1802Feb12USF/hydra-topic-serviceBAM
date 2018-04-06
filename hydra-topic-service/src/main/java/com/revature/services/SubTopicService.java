package com.revature.services;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Batch;
import com.revature.model.Subtopic;
import com.revature.model.SubtopicName;
import com.revature.model.SubtopicStatus;
import com.revature.model.SubtopicType;
import com.revature.repository.SubtopicNameRepository;
import com.revature.repository.SubtopicRepository;
import com.revature.repository.SubtopicStatusRepository;
import com.revature.repository.SubtopicTypeRepository;

@Service
public class SubTopicService {
	
	@Autowired
	SubtopicRepository subtopicRepository;

	@Autowired
	SubtopicNameRepository subtopicNameRepository;

	@Autowired
	SubtopicStatusRepository subtopicStatusRepository;

	@Autowired
	SubtopicTypeRepository subtopicTypeRepository;

	/**
	 * adds a subtopic to the list of topics to be reviewed 
	 * for a batch, with the given id
	 * 
	 * @param subtopic
	 * @param batch
	 */
	public void addSubtopic(int subtopic, int batch){
		Subtopic s = new Subtopic();
		Batch b;
		SubtopicName st;
		SubtopicStatus ss;
		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = dateFormat.parse("23/09/2017");
		} catch (Exception e) {
			System.out.println("Error");
		}
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		st = subtopicNameRepository.findByid(subtopic);
		ss = subtopicStatusRepository.findByid(1);
	
		s.setSubtopicName(st);
		s.setStatus(ss);
		s.setSubtopicDate(ts);
	    subtopicRepository.save(s);
	}

	/**
	 * lists out the topics to be covered by a batch
	 * 
	 * @param batch
	 * @return List<Subtopic>
	 */
	public List<Subtopic> getSubtopicByBatch(Batch batch) {
		return subtopicRepository.findByBatch(batch);
	}

	/**
	 * 
	 * @param subtopic
	 *          Persisting subtopic to database.
	 *          To handle timezone offset, before submission to DB,
	 *          adding offset to date and updating date.
	 * 
	 * @author Samuel Louis-Pierre, Avant Mathur
	 */
	public void updateSubtopic(Subtopic subtopic) {
		Long newDate = subtopic.getSubtopicDate().getTime() + 46800000;
		subtopic.setSubtopicDate(new Timestamp(newDate));
	    subtopicRepository.save(subtopic);
	}

	public SubtopicStatus getStatus(String name) {
		return subtopicStatusRepository.findByName(name);
	}

	/**
	 * Service method to return the number of Subtopics by matching their ids with
	 * the batchId.
	 * 
	 * @param batchId(int)
	 * @return number(long) of Subtopics
	 * 
	 * @author Michael Garza, Gary LaMountain
	 */
	public Long getNumberOfSubtopics(int batchId) {
		return subtopicRepository.countSubtopicsByBatchBatchId(batchId);
	}

	public List<SubtopicName> getAllSubtopics() {
		return subtopicNameRepository.findAll();
	}

	public List<Subtopic> getSubtopics() {
		return subtopicRepository.findAll();
	}

	/**
	 * find the subtopic entry given the name
	 * 
	 * @param String name
	 * @return SubtopicName
	 */
	public SubtopicName getSubtopicName(String name) {
		return subtopicNameRepository.findByName(name);
	}

	/**
	 * find the subtopic type entry given the type
	 * 
	 * @param int type
	 * @return SubtopicType
	 */
	public SubtopicType getSubtopicType(int type) {
		return subtopicTypeRepository.findByid(type);
	}

	/**
	 * add or update the subtopic entry with the given entry
	 * 
	 * @param SubtopicName subtopicName
	 * @author Brian McKalip
	 */
	public void addOrUpdateSubtopicName(SubtopicName subtopicName) {
		subtopicNameRepository.save(subtopicName);
	}
}
