package com.todoApplication.backend.Business;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todoApplication.backend.Entities.DbSequence;
import com.todoApplication.backend.DataAccess.ITaskRepo;
import com.todoApplication.backend.Entities.Task;

@Service
public class TaskManager implements ITaskService {
	
	@Autowired
	private ITaskRepo taskRepo;
	
	 @Autowired
	 private MongoOperations mongoOperations;
	 
	 public int getSequenceNumber(String sequenceName) {
		 
		 //get squence_no
		 Query query = new Query(Criteria.where("id").is(sequenceName));
		 //update sequence_no
		 Update update = new Update().inc("seq", 1);
		 //modify in document
		 DbSequence counter = mongoOperations.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), DbSequence.class);
		 return !Objects.isNull(counter) ? counter.getSeq() : 1;
		 
	}
	
	
	@Override
	@Transactional
	public List<Task> getAll() {
		
		return ((List<Task>)this.taskRepo.findAll());
	}

	@Override
	public Task add(Task task) {
		try {
			taskRepo.save(task);
			return task;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}

	@Override
	public Task update(Task task) {
		try {
			 taskRepo.save(task);
			 return task;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }
		return null;
	}

	@Override
	public Task delete(int id) {
		try {
			  taskRepo.deleteById(id); 
			  return (Task)this.taskRepo.findById(id);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }
		return null;
		
	}

	@Override
	public Task getById(int id) {
		
		return (Task)this.taskRepo.findById(id);
	}

}
